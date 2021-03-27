package com.mugen.riot.api;

import com.mugen.riot.model.ChampionMastery;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface ChampionMasteryApi {

    @GET("/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}")
    Observable<List<ChampionMastery>> getChampionMasteriesBySummoner(@Path("encryptedSummonerId") String encryptedSummonerId, @Query("api_key") String apiKey);

    @GET("/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}")
    Observable<ChampionMastery> getChampionMasteryBySummoner(@Path("encryptedSummonerId") String encryptedSummonerId, @Path("championId") String championId, @Query("api_key") String apiKey);

    @GET("/lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}")
    Observable<Integer> getChampionMasteryScoreBySummoner(@Path("encryptedSummonerId") String encryptedSummonerId, @Query("api_key") String apiKey);

}
