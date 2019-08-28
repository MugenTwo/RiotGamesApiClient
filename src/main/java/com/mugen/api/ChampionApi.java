package com.mugen.api;

import com.mugen.model.Champion;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChampionApi {

    @GET("/lol/platform/v3/champion-rotations")
    Single<Champion> getChampionRotations(@Query("api_key") String apiKey);

}
