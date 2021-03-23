package com.mugen.riot.service.reactive;

import com.mugen.riot.api.reactive.SummonerApi;
import com.mugen.riot.model.Region;
import com.mugen.riot.model.Summoner;
import com.mugen.riot.service.reactive.SummonerService;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SummonerServiceTest {

    @Test
    void findByNameTest() {
        String summonerName = "testSummoner";
        String apiKey = "testKey";
        Map<Region, SummonerApi> summonerApiByRegion = new HashMap<>();
        SummonerApi summonerApi = mock(SummonerApi.class);
        summonerApiByRegion.put(Region.EUROPE_WEST, summonerApi);
        Summoner summoner = Summoner.builder()
                .name(summonerName)
                .build();
        when(summonerApi.findByName(summonerName, apiKey)).thenReturn(Single.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Single<Summoner> result = summonerService.findByName(summonerName, Region.EUROPE_WEST);
        Summoner summonerResult = result.blockingGet();

        assertThat(summonerResult.getName()).isEqualToIgnoringCase(summonerName);
    }

    @Test
    void findByEncryptedAccountIdTest() {
        String encryptedAccountId = "testEncryptedAccountId";
        String apiKey = "testKey";
        Map<Region, SummonerApi> summonerApiByRegion = new HashMap<>();
        SummonerApi summonerApi = mock(SummonerApi.class);
        summonerApiByRegion.put(Region.EUROPE_WEST, summonerApi);
        Summoner summoner = Summoner.builder()
                .accountId(encryptedAccountId)
                .build();
        when(summonerApi.findByEncryptedAccountId(encryptedAccountId, apiKey)).thenReturn(Single.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Single<Summoner> result = summonerService.findByEncryptedAccountId(encryptedAccountId, Region.EUROPE_WEST);
        Summoner summonerResult = result.blockingGet();

        assertThat(summonerResult.getAccountId()).isEqualTo(encryptedAccountId);
    }

    @Test
    void findByEncryptedPuuidTest() {
        String encryptedPuuid = "testPuuid";
        String apiKey = "testKey";
        Map<Region, SummonerApi> summonerApiByRegion = new HashMap<>();
        SummonerApi summonerApi = mock(SummonerApi.class);
        summonerApiByRegion.put(Region.EUROPE_WEST, summonerApi);
        Summoner summoner = Summoner.builder()
                .puuid(encryptedPuuid)
                .build();
        when(summonerApi.findByEncryptedPuuid(encryptedPuuid, apiKey)).thenReturn(Single.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Single<Summoner> result = summonerService.findByEncryptedPuuid(encryptedPuuid, Region.EUROPE_WEST);
        Summoner summonerResult = result.blockingGet();

        assertThat(summonerResult.getPuuid()).isEqualTo(encryptedPuuid);
    }

    @Test
    void findByEncryptedSummonerIdTest() {
        String encryptedSummonerId = "testEncryptedSummonerId";
        String apiKey = "testKey";
        Map<Region, SummonerApi> summonerApiByRegion = new HashMap<>();
        SummonerApi summonerApi = mock(SummonerApi.class);
        summonerApiByRegion.put(Region.EUROPE_WEST, summonerApi);
        Summoner summoner = Summoner.builder()
                .id(encryptedSummonerId)
                .build();
        when(summonerApi.findByEncryptedSummonerId(encryptedSummonerId, apiKey)).thenReturn(Single.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Single<Summoner> result = summonerService.findByEncryptedSummonerId(encryptedSummonerId, Region.EUROPE_WEST);
        Summoner summonerResult = result.blockingGet();

        assertThat(summonerResult.getId()).isEqualTo(encryptedSummonerId);
    }

}