package com.mugen.riot.service;

import com.mugen.riot.model.match.Match;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface MatchService {

    @GET("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    Observable<List<String>> getMatchesByPuuid(
            @Path("puuid") String puuid,
            @Query("start") int start,
            @Query("count") int count
    );

    // TODO: The DTO of this endpoint is unstable
    @GET("/lol/match/v5/matches/{matchId}")
    Observable<Match> getMatch(@Path("matchId") String matchId);

}
