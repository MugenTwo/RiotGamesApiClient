package com.mugen.riot;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
public class RegionApiProvider {

    private static final String PROTOCOL_URL = "https://";
    private static final String LEAGUE_OF_LEGENDS_API_URL = ".api.riotgames.com";

    @Getter
    @ToString.Exclude
    private final String apiKey;
    private final OkHttpClient okHttpClient;
    private final Map<Region, Retrofit> retrofitByRegion;

    public RegionApiProvider(String apiKey) {
        this.apiKey = apiKey;
        this.okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new RiotApiHeaderInterceptor(apiKey))
                .build();
        this.retrofitByRegion = Arrays.stream(Region.values())
                .collect(Collectors.toMap(
                        Function.identity(), this::buildRetrofit,
                        (region1, region2) -> region1, () -> new EnumMap<>(Region.class)
                ));
    }

    public <T> Map<Region, T> generateApiByRegion(Class<T> api) {
        return Arrays.stream(Region.values())
                .collect(Collectors.toMap(
                        Function.identity(), region -> this.retrofitByRegion.get(region).create(api),
                        (region1, region2) -> region1, () -> new EnumMap<>(Region.class)
                ));
    }

    private Retrofit buildRetrofit(Region region) {
        return new Retrofit.Builder()
                .baseUrl(PROTOCOL_URL + region.getAcronym() + LEAGUE_OF_LEGENDS_API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
