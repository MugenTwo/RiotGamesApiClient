package com.mugen;

import com.mugen.model.Region;
import lombok.Value;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Value
public class RegionApiProvider {

    private static final String PROTOCOL_URL = "https://";
    private static final String LEAGUE_OF_LEGENDS_API_URL = ".api.riotgames.com";

    String apiKey;
    Map<Region, Retrofit> retrofitByRegion;

    public RegionApiProvider(String apiKey) {
        this.apiKey = apiKey;
        this.retrofitByRegion = Arrays.stream(Region.values())
                .collect(Collectors.toMap(
                        Function.identity(), this::buildRetrofit,
                        (region1, region2) -> region1, () -> new EnumMap<>(Region.class)
                ));
    }

    private Retrofit buildRetrofit(Region region) {
        return new Retrofit.Builder()
                .baseUrl(PROTOCOL_URL + region.getAcronym() + LEAGUE_OF_LEGENDS_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
