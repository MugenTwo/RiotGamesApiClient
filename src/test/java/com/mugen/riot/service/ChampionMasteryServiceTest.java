package com.mugen.riot.service;

import com.mugen.riot.api.ChampionMasteryApi;
import com.mugen.riot.model.ChampionMastery;
import com.mugen.riot.Region;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChampionMasteryServiceTest {

    @Test
    void getChampionMasteriesBySummonerTest() {
        int championLevel = 3;
        int championPoints = 15000;
        long championId = 92;
        long championPointsUntilNextLevel = 3456;
        long lastPlayTime = 1565988651020L;
        int tokensEarned = 0;
        long championPointsSinceLastLevel = 5436;
        String encryptedSummonerId = "testEncryptedSummonerId";
        String apiKey = "testKey";
        Map<Region, ChampionMasteryApi> championMasteryApiByRegion = new HashMap<>();
        ChampionMasteryApi championMasteryApi = mock(ChampionMasteryApi.class);
        championMasteryApiByRegion.put(Region.EUROPE_WEST, championMasteryApi);
        ChampionMastery championMastery = ChampionMastery.builder()
                .championLevel(championLevel)
                .championPoints(championPoints)
                .championId(championId)
                .championPointsUntilNextLevel(championPointsUntilNextLevel)
                .lastPlayTime(lastPlayTime)
                .tokensEarned(tokensEarned)
                .championPointsSinceLastLevel(championPointsSinceLastLevel)
                .build();
        when(championMasteryApi.getChampionMasteriesBySummoner(encryptedSummonerId, apiKey)).thenReturn(Observable.just(Collections.singletonList(championMastery)));
        ChampionMasteryService championMasteryService = new ChampionMasteryService(apiKey, championMasteryApiByRegion);

        Observable<List<ChampionMastery>> result = Observable.fromPublisher(
                championMasteryService.getChampionMasteriesBySummoner(encryptedSummonerId, Region.EUROPE_WEST)
        );
        List<ChampionMastery> championMasteriesResult = result.blockingFirst();

        assertThat(championMasteriesResult).isEqualTo(List.of(
                ChampionMastery.builder()
                        .championLevel(championLevel)
                        .championPoints(championPoints)
                        .championId(championId)
                        .championPointsUntilNextLevel(championPointsUntilNextLevel)
                        .lastPlayTime(lastPlayTime)
                        .tokensEarned(tokensEarned)
                        .championPointsSinceLastLevel(championPointsSinceLastLevel)
                        .build()
        ));
    }

    @Test
    void getChampionMasteryBySummonerTest() {
        boolean chestGranted = false;
        int championLevel = 3;
        int championPoints = 15000;
        long championId = 92;
        long championPointsUntilNextLevel = 3456;
        long lastPlayTime = 1565988651020L;
        int tokensEarned = 0;
        long championPointsSinceLastLevel = 5436;
        String encryptedSummonerId = "testEncryptedSummonerId";
        String apiKey = "testKey";
        Map<Region, ChampionMasteryApi> championMasteryApiByRegion = new HashMap<>();
        ChampionMasteryApi championMasteryApi = mock(ChampionMasteryApi.class);
        championMasteryApiByRegion.put(Region.EUROPE_WEST, championMasteryApi);
        ChampionMastery championMastery = ChampionMastery.builder()
                .chestGranted(chestGranted)
                .championLevel(championLevel)
                .championPoints(championPoints)
                .championId(championId)
                .championPointsUntilNextLevel(championPointsUntilNextLevel)
                .lastPlayTime(lastPlayTime)
                .tokensEarned(tokensEarned)
                .championPointsSinceLastLevel(championPointsSinceLastLevel)
                .build();
        when(championMasteryApi.getChampionMasteryBySummoner(encryptedSummonerId, Long.toString(championId), apiKey)).thenReturn(Observable.just(championMastery));
        ChampionMasteryService championMasteryService = new ChampionMasteryService(apiKey, championMasteryApiByRegion);

        Observable<ChampionMastery> result = Observable.fromPublisher(
                championMasteryService.getChampionMasteryBySummoner(encryptedSummonerId, Long.toString(championId), Region.EUROPE_WEST)
        );
        ChampionMastery championMasteryResult = result.blockingFirst();

        assertThat(championMasteryResult).isEqualTo(
                ChampionMastery.builder()
                        .championLevel(championLevel)
                        .championPoints(championPoints)
                        .championId(championId)
                        .championPointsUntilNextLevel(championPointsUntilNextLevel)
                        .lastPlayTime(lastPlayTime)
                        .tokensEarned(tokensEarned)
                        .championPointsSinceLastLevel(championPointsSinceLastLevel)
                        .build()
        );
    }

    @Test
    void getChampionMasteryScoreBySummonerTest() {
        int score = 3;
        String encryptedSummonerId = "testEncryptedSummonerId";
        String apiKey = "testKey";
        Map<Region, ChampionMasteryApi> championMasteryApiByRegion = new HashMap<>();
        ChampionMasteryApi championMasteryApi = mock(ChampionMasteryApi.class);
        championMasteryApiByRegion.put(Region.EUROPE_WEST, championMasteryApi);
        when(championMasteryApi.getChampionMasteryScoreBySummoner(encryptedSummonerId, apiKey)).thenReturn(Observable.just(score));
        ChampionMasteryService championMasteryService = new ChampionMasteryService(apiKey, championMasteryApiByRegion);

        Observable<Integer> result = Observable.fromPublisher(
                championMasteryService.getChampionMasteryScoreBySummoner(encryptedSummonerId, Region.EUROPE_WEST)
        );
        Integer scoreResult = result.blockingFirst();

        assertThat(scoreResult).isEqualTo(score);
    }


}