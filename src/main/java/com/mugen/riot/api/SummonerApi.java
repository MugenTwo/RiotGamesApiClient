package com.mugen.riot.api;

import com.mugen.riot.model.Summoner;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SummonerApi {

    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    Observable<Summoner> getByName(@Path("summonerName") String name);

    @GET("/lol/summoner/v4/summoners/by-account/{encryptedAccountId}")
    Observable<Summoner> getByEncryptedAccountId(@Path("encryptedAccountId") String encryptedAccountId);

    @GET("/lol/summoner/v4/summoners/by-puuid/{encryptedPuuid}")
    Observable<Summoner> getByEncryptedPuuid(@Path("encryptedPuuid") String encryptedPuuid);

    @GET("/lol/summoner/v4/summoners/{encryptedSummonerId}")
    Observable<Summoner> getByEncryptedSummonerId(@Path("encryptedSummonerId") String encryptedSummonerId);

}
