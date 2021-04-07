package com.mugen.riot.api;

import com.mugen.riot.model.spectator.CurrentGame;
import com.mugen.riot.model.spectator.FeaturedGame;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpectatorApi {

    @GET("/lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}")
    Observable<CurrentGame> getActiveGameBySummoner(@Path("encryptedSummonerId") String encryptedSummonerId);

    @GET("/lol/spectator/v4/featured-games")
    Observable<FeaturedGame> getFeaturedGames();

}
