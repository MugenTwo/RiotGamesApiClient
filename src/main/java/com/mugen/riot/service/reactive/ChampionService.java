package com.mugen.riot.service.reactive;

import com.mugen.riot.RegionApiProvider;
import com.mugen.riot.api.reactive.ChampionApi;
import com.mugen.riot.model.ChampionRotation;
import com.mugen.riot.model.Region;
import io.reactivex.Single;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import retrofit2.Retrofit;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class ChampionService {

    private final String apiKey;
    private final Map<Region, ChampionApi> championApiByRegion;

    @lombok.experimental.Tolerate
    public ChampionService(RegionApiProvider regionApiProvider) {
        Map<Region, Retrofit> retrofitByRegion = regionApiProvider.getRetrofitByRegion();
        this.apiKey = regionApiProvider.getApiKey();
        this.championApiByRegion = Arrays.stream(Region.values())
                .collect(Collectors.toMap(
                        Function.identity(), region -> retrofitByRegion.get(region).create(ChampionApi.class),
                        (region1, region2) -> region1, () -> new EnumMap<>(Region.class)
                ));
    }

    /**
     * Calls League of Legends API to get the champion rotations, including free-to-play and low-level free-to-play rotations
     *
     * @param region to get info from
     * @return A Single containing the champion rotations
     */
    public Single<ChampionRotation> getChampionRotations(Region region) {
        return this.championApiByRegion.get(region).getChampionRotations(this.apiKey);
    }

}
