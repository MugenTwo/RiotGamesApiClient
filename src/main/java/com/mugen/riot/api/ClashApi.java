package com.mugen.riot.api;

import com.mugen.riot.model.clash.ClashTeam;
import com.mugen.riot.model.Player;
import com.mugen.riot.model.clash.Tournament;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ClashApi {

    @GET("/lol/clash/v1/players/by-summoner/{summonerId}")
    Observable<List<Player>> getPlayerBySummonerId(@Path("summonerId") String summonerId);

    @GET("/lol/clash/v1/teams/{teamId}}")
    Observable<ClashTeam> getTeam(@Path("teamId") String teamId);

    @GET("/lol/clash/v1/tournaments")
    Observable<List<Tournament>> getTournaments();

    @GET("/lol/clash/v1/tournaments/by-team/{teamId}")
    Observable<List<Tournament>> getTournamentByTeamId(@Path("teamId") String teamId);

    @GET("/lol/clash/v1/tournaments/{tournamentId}")
    Observable<Tournament> getTournamentById(@Path("tournamentId") String tournamentId);

}
