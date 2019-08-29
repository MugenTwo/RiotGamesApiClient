package com.mugen.service;

import com.mugen.api.ChampionMasteryApi;
import com.mugen.model.ChampionMastery;
import com.mugen.model.Region;
import io.reactivex.Single;
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
        when(championMasteryApi.getChampionMasteriesBySummoner(encryptedSummonerId, apiKey)).thenReturn(Single.just(Collections.singletonList(championMastery)));
        ChampionMasteryService championMasteryService = new ChampionMasteryService(apiKey, championMasteryApiByRegion);

        Single<List<ChampionMastery>> result = championMasteryService.getChampionMasteriesBySummoner(encryptedSummonerId, Region.EUROPE_WEST);
        List<ChampionMastery> championMasteriesResult = result.blockingGet();

        assertThat(championMasteriesResult.get(0).isChestGranted()).isFalse();
        assertThat(championMasteriesResult.get(0).getChampionLevel()).isEqualTo(championLevel);
        assertThat(championMasteriesResult.get(0).getChampionPoints()).isEqualTo(championPoints);
        assertThat(championMasteriesResult.get(0).getChampionId()).isEqualTo(championId);
        assertThat(championMasteriesResult.get(0).getChampionPointsUntilNextLevel()).isEqualTo(championPointsUntilNextLevel);
        assertThat(championMasteriesResult.get(0).getLastPlayTime()).isEqualTo(lastPlayTime);
        assertThat(championMasteriesResult.get(0).getTokensEarned()).isEqualTo(tokensEarned);
        assertThat(championMasteriesResult.get(0).getChampionPointsSinceLastLevel()).isEqualTo(championPointsSinceLastLevel);
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
        when(championMasteryApi.getChampionMasteryBySummoner(encryptedSummonerId, Long.toString(championId), apiKey)).thenReturn(Single.just(championMastery));
        ChampionMasteryService championMasteryService = new ChampionMasteryService(apiKey, championMasteryApiByRegion);

        Single<ChampionMastery> result = championMasteryService.getChampionMasteryBySummoner(encryptedSummonerId, Long.toString(championId), Region.EUROPE_WEST);
        ChampionMastery championMasteryResult = result.blockingGet();

        assertThat(championMasteryResult.isChestGranted()).isFalse();
        assertThat(championMasteryResult.getChampionLevel()).isEqualTo(championLevel);
        assertThat(championMasteryResult.getChampionPoints()).isEqualTo(championPoints);
        assertThat(championMasteryResult.getChampionId()).isEqualTo(championId);
        assertThat(championMasteryResult.getChampionPointsUntilNextLevel()).isEqualTo(championPointsUntilNextLevel);
        assertThat(championMasteryResult.getLastPlayTime()).isEqualTo(lastPlayTime);
        assertThat(championMasteryResult.getTokensEarned()).isEqualTo(tokensEarned);
        assertThat(championMasteryResult.getChampionPointsSinceLastLevel()).isEqualTo(championPointsSinceLastLevel);
    }

    @Test
    void getChampionMasteryScoreBySummonerTest() {
        int score = 3;
        String encryptedSummonerId = "testEncryptedSummonerId";
        String apiKey = "testKey";
        Map<Region, ChampionMasteryApi> championMasteryApiByRegion = new HashMap<>();
        ChampionMasteryApi championMasteryApi = mock(ChampionMasteryApi.class);
        championMasteryApiByRegion.put(Region.EUROPE_WEST, championMasteryApi);
        when(championMasteryApi.getChampionMasteryScoreBySummoner(encryptedSummonerId, apiKey)).thenReturn(Single.just(score));
        ChampionMasteryService championMasteryService = new ChampionMasteryService(apiKey, championMasteryApiByRegion);

        Single<Integer> result = championMasteryService.getChampionMasteryScoreBySummoner(encryptedSummonerId, Region.EUROPE_WEST);
        Integer scoreResult = result.blockingGet();

        assertThat(scoreResult).isEqualTo(score);
    }


}