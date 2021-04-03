package com.mugen.riot.api;

import com.mugen.riot.model.platform.PlatformData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LolStatusApi {

    // This endpoint seems to be broken because it doesn't accept header params
    @GET("/lol/status/v4/platform-data")
    Observable<PlatformData> getServerStatus(@Query("api_key") String apiKey);

}
