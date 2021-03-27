package com.mugen.riot.service;

import com.mugen.riot.api.SummonerApi;
import com.mugen.riot.Region;
import com.mugen.riot.model.Summoner;
import io.reactivex.Observable;
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
        when(summonerApi.findByName(summonerName, apiKey)).thenReturn(Observable.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Observable<Summoner> result = Observable.fromPublisher(summonerService.findByName(summonerName, Region.EUROPE_WEST));
        Summoner summonerResult = result.blockingFirst();

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
        when(summonerApi.findByEncryptedAccountId(encryptedAccountId, apiKey)).thenReturn(Observable.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Observable<Summoner> result = Observable.fromPublisher(summonerService.findByEncryptedAccountId(encryptedAccountId, Region.EUROPE_WEST));
        Summoner summonerResult = result.blockingFirst();

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
        when(summonerApi.findByEncryptedPuuid(encryptedPuuid, apiKey)).thenReturn(Observable.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Observable<Summoner> result = Observable.fromPublisher(summonerService.findByEncryptedPuuid(encryptedPuuid, Region.EUROPE_WEST));
        Summoner summonerResult = result.blockingFirst();

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
        when(summonerApi.findByEncryptedSummonerId(encryptedSummonerId, apiKey)).thenReturn(Observable.just(summoner));
        SummonerService summonerService = new SummonerService(apiKey, summonerApiByRegion);

        Observable<Summoner> result = Observable.fromPublisher(summonerService.findByEncryptedSummonerId(encryptedSummonerId, Region.EUROPE_WEST));
        Summoner summonerResult = result.blockingFirst();

        assertThat(summonerResult.getId()).isEqualTo(encryptedSummonerId);
    }

}