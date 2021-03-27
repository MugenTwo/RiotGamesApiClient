package com.mugen.riot.api;

import com.mugen.riot.model.Summoner;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SummonerApi {

    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    Observable<Summoner> findByName(@Path("summonerName") String name, @Query("api_key") String apiKey);

    @GET("/lol/summoner/v4/summoners/by-account/{encryptedAccountId}")
    Observable<Summoner> findByEncryptedAccountId(@Path("encryptedAccountId") String encryptedAccountId, @Query("api_key") String apiKey);

    @GET("/lol/summoner/v4/summoners/by-puuid/{encryptedPuuid}")
    Observable<Summoner> findByEncryptedPuuid(@Path("encryptedPuuid") String encryptedPuuid, @Query("api_key") String apiKey);

    @GET("/lol/summoner/v4/summoners/{encryptedSummonerId}")
    Observable<Summoner> findByEncryptedSummonerId(@Path("encryptedSummonerId") String encryptedSummonerId, @Query("api_key") String apiKey);

}
