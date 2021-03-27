package com.mugen.riot.api;

import com.mugen.riot.model.ChampionRotation;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChampionApi {

    @GET("/lol/platform/v3/champion-rotations")
    Observable<ChampionRotation> getChampionRotations(@Query("api_key") String apiKey);

}
