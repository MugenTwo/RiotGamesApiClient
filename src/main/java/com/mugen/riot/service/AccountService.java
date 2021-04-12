package com.mugen.riot.service;

import com.mugen.riot.model.account.Account;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AccountService {

    @GET("/riot/account/v1/accounts/by-puuid/{puuid}")
    Observable<Account> getAccountByPuuid(@Path("puuid") String puuid);

    @GET("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    Observable<Account> getAccountByGameNameAndTagLine(@Path("gameName") String gameName, @Path("tagLine") String tagLine);

    @GET("/riot/account/v1/active-shards/by-game/{game}/by-puuid/{puuid}")
    Observable<Account> getAccountByGameAndPuuid(@Path("game") String game, @Path("tagLine") String puuid);

}
