package com.mugen.riot.service.reactive;

import com.mugen.riot.api.reactive.ChampionApi;
import com.mugen.riot.model.ChampionRotation;
import com.mugen.riot.model.Region;
import com.mugen.riot.service.reactive.ChampionService;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChampionRotationServiceTest {

    @Test
    void getChampionRotationsTest() {
        List<Integer> freeChampionIdsForNewPlayers = List.of(18, 81, 92, 141, 37, 238, 19, 45, 25, 64);
        List<Integer> freeChampionIds = List.of(10, 16, 36, 56, 61, 69, 79, 85, 101, 111, 127, 145, 150, 236);
        int maxNewPlayerLevel = 10;
        String apiKey = "testKey";
        Map<Region, ChampionApi> championApiByRegion = new HashMap<>();
        ChampionApi championApi = mock(ChampionApi.class);
        championApiByRegion.put(Region.EUROPE_WEST, championApi);
        ChampionRotation championRotation = ChampionRotation.builder()
                .freeChampionIdsForNewPlayers(freeChampionIdsForNewPlayers)
                .freeChampionIds(freeChampionIds)
                .maxNewPlayerLevel(maxNewPlayerLevel)
                .build();
        when(championApi.getChampionRotations(apiKey)).thenReturn(Single.just(championRotation));
        ChampionService championService = new ChampionService(apiKey, championApiByRegion);

        Single<ChampionRotation> result = championService.getChampionRotations(Region.EUROPE_WEST);
        ChampionRotation championRotationResult = result.blockingGet();

        assertThat(championRotationResult).isEqualTo(
                ChampionRotation.builder()
                        .freeChampionIdsForNewPlayers(freeChampionIdsForNewPlayers)
                        .freeChampionIds(freeChampionIds)
                        .maxNewPlayerLevel(maxNewPlayerLevel)
                        .build()
        );
    }

}