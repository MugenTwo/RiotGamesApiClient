package com.mugen.riot.service;

import com.mugen.riot.RegionApiProvider;
import com.mugen.riot.api.SummonerApi;
import com.mugen.riot.Region;
import com.mugen.riot.model.Summoner;
import io.reactivex.BackpressureStrategy;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.reactivestreams.Publisher;

import java.util.Map;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class SummonerService {

    private final String apiKey;
    private final Map<Region, SummonerApi> summonerApiByRegion;

    public SummonerService(RegionApiProvider regionApiProvider) {
        this.apiKey = regionApiProvider.getApiKey();
        this.summonerApiByRegion = regionApiProvider.generateApiByRegion(SummonerApi.class);
    }

    /**
     * Calls League of Legends API to find a Summoner by name
     *
     * @param name   of the Summoner
     * @param region to search in
     * @return A Publisher containing a Summoner with the provided name
     */
    public Publisher<Summoner> findByName(String name, Region region) {
        return this.summonerApiByRegion.get(region).findByName(name, this.apiKey).toFlowable(BackpressureStrategy.BUFFER);
    }

    /**
     * Calls League of Legends API to find a Summoner by encryptedAccountId
     *
     * @param encryptedAccountId of the Summoner
     * @param region             to search in
     * @return A Publisher containing a Summoner with the provided encryptedAccountId
     */
    public Publisher<Summoner> findByEncryptedAccountId(String encryptedAccountId, Region region) {
        return this.summonerApiByRegion.get(region).findByEncryptedAccountId(encryptedAccountId, this.apiKey)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    /**
     * Calls League of Legends API to find a Summoner by encryptedPuuid
     *
     * @param encryptedPuuid of the Summoner
     * @param region         to search in
     * @return A Publisher containing a Summoner with the provided encryptedPuuid
     */
    public Publisher<Summoner> findByEncryptedPuuid(String encryptedPuuid, Region region) {
        return this.summonerApiByRegion.get(region).findByEncryptedPuuid(encryptedPuuid, this.apiKey)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    /**
     * Calls League of Legends API to find a Summoner by encryptedSummonerId
     *
     * @param encryptedSummonerId of the Summoner
     * @param region              to search in
     * @return A Publisher containing a Summoner with the provided encryptedSummonerId
     */
    public Publisher<Summoner> findByEncryptedSummonerId(String encryptedSummonerId, Region region) {
        return this.summonerApiByRegion.get(region).findByEncryptedSummonerId(encryptedSummonerId, this.apiKey)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

}
