package com.mugen.riot.service;

import com.mugen.riot.model.league.LeagueEntry;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.Set;

public interface LeagueExpService {

    @GET("/lol/league-exp/v4/entries/{queue}/{tier}/{division}")
    Set<LeagueEntry> getLeagueEntries(
            @Path("queue") String queue,
            @Path("tier") String tier,
            @Path("division") String division
    );

}
