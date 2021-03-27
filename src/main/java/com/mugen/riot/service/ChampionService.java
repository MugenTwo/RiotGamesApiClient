package com.mugen.riot.service;

import com.mugen.riot.RegionApiProvider;
import com.mugen.riot.api.ChampionApi;
import com.mugen.riot.model.ChampionRotation;
import com.mugen.riot.Region;
import io.reactivex.Single;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ChampionService {

    private final String apiKey;
    private final Map<Region, ChampionApi> championApiByRegion;

    public ChampionService(RegionApiProvider regionApiProvider) {
        this.apiKey = regionApiProvider.getApiKey();
        this.championApiByRegion = regionApiProvider.generateApiByRegion(ChampionApi.class);
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
