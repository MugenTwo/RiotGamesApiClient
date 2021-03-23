package com.mugen.riot.service.reactive;

import com.mugen.riot.RegionApiProvider;
import com.mugen.riot.api.reactive.SummonerApi;
import com.mugen.riot.model.Region;
import com.mugen.riot.model.Summoner;
import io.reactivex.Single;
import lombok.Builder;
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

@Builder
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class SummonerService {

    private final String apiKey;
    private final Map<Region, SummonerApi> summonerApiByRegion;

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
