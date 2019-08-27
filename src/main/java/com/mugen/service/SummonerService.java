package com.mugen.service;

import com.mugen.RegionApiProvider;
import com.mugen.api.SummonerApi;
import com.mugen.model.Region;
import com.mugen.model.Summoner;
import io.reactivex.Single;
import lombok.Value;
import retrofit2.Retrofit;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Value
public class SummonerService {

    private String apiKey;
    private Map<Region, SummonerApi> summonerApiByRegion;

    @lombok.experimental.Tolerate
    public SummonerService(RegionApiProvider regionApiProvider) {
        Map<Region, Retrofit> retrofitByRegion = regionApiProvider.getRetrofitByRegion();
        this.apiKey = regionApiProvider.getApiKey();
        this.summonerApiByRegion = Arrays.stream(Region.values())
                .collect(Collectors.toMap(
                        Function.identity(), region -> retrofitByRegion.get(region).create(SummonerApi.class),
                        (region1, region2) -> region1, () -> new EnumMap<>(Region.class)
                ));
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
