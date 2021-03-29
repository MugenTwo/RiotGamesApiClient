package com.mugen.riot.api;

import com.mugen.riot.model.league.LeagueEntry;
import com.mugen.riot.model.league.LeagueList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LeagueApi {

    @GET("/lol/league/v4/challengerleagues/by-queue/{queue}")
    Observable<LeagueList> getChallengerLeaguesByQueue(@Path("queue") String queue);

    @GET("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    Observable<LeagueEntry> getLeagueEntriesByEncryptedAccountId(@Path("encryptedSummonerId") String encryptedSummonerId);

    @GET("/lol/league/v4/entries/{queue}/{tier}/{division}")
    Observable<LeagueEntry> getAllLeagueEntries(
            @Path("queue") String queue,
            @Path("tier") String tier,
            @Path("division") String division
    );

    @GET("/lol/league/v4/grandmasterleagues/by-queue/{queue}")
    Observable<LeagueList> getGrandMasterLeaguesByQueue(@Path("queue") String queue);

    @GET("/lol/league/v4/leagues/{leagueId}")
    Observable<LeagueList> getLeagueById(@Path("leagueId") String leagueId);

    @GET("/lol/league/v4/masterleagues/by-queue/{queue}")
    Observable<LeagueList> getLeagueByQueue(@Path("queue") String queue);

}
