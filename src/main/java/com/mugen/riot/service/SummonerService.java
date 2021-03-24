package com.mugen.riot.service;

import com.mugen.riot.RegionApiProvider;
import com.mugen.riot.api.SummonerApi;
import com.mugen.riot.model.Region;
import com.mugen.riot.model.Summoner;
import io.reactivex.Single;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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
     * @return A Single containing a Summoner with the provided name
     */
    public Single<Summoner> findByName(String name, Region region) {
        return this.summonerApiByRegion.get(region).findByName(name, this.apiKey);
    }

    /**
     * Calls League of Legends API to find a Summoner by encryptedAccountId
     *
     * @param encryptedAccountId of the Summoner
     * @param region             to search in
     * @return A Single containing a Summoner with the provided encryptedAccountId
     */
    public Single<Summoner> findByEncryptedAccountId(String encryptedAccountId, Region region) {
        return this.summonerApiByRegion.get(region).findByEncryptedAccountId(encryptedAccountId, this.apiKey);
    }

    /**
     * Calls League of Legends API to find a Summoner by encryptedPuuid
     *
     * @param encryptedPuuid of the Summoner
     * @param region         to search in
     * @return A Single containing a Summoner with the provided encryptedPuuid
     */
    public Single<Summoner> findByEncryptedPuuid(String encryptedPuuid, Region region) {
        return this.summonerApiByRegion.get(region).findByEncryptedPuuid(encryptedPuuid, this.apiKey);
    }

    /**
     * Calls League of Legends API to find a Summoner by encryptedSummonerId
     *
     * @param encryptedSummonerId of the Summoner
     * @param region              to search in
     * @return A Single containing a Summoner with the provided encryptedSummonerId
     */
    public Single<Summoner> findByEncryptedSummonerId(String encryptedSummonerId, Region region) {
        return this.summonerApiByRegion.get(region).findByEncryptedSummonerId(encryptedSummonerId, this.apiKey);
    }

}
