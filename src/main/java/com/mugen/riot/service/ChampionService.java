package com.mugen.riot.service;

import com.mugen.riot.model.champion.ChampionRotation;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ChampionService {

    @GET("/lol/platform/v3/champion-rotations")
    Observable<ChampionRotation> getChampionRotations();

}
