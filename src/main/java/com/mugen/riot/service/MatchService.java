package com.mugen.riot.service;

import com.mugen.riot.model.match.Match;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MatchService {

    @GET("/lol/match/v4/matches/{matchId}")
    Observable<Match> getMatch(@Query("matchId") String matchId);

}
