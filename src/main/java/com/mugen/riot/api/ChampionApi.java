package com.mugen.riot.api;

import com.mugen.riot.model.champion.ChampionRotation;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ChampionApi {

    @GET("/lol/platform/v3/champion-rotations")
    Observable<ChampionRotation> getChampionRotations();

}
