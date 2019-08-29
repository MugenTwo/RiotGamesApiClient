package com.mugen.service;

import com.mugen.RegionApiProvider;
import com.mugen.api.ChampionMasteryApi;
import com.mugen.model.ChampionMastery;
import com.mugen.model.Region;
import io.reactivex.Single;
import lombok.Value;
import retrofit2.Retrofit;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Value
public class ChampionMasteryService {

    private String apiKey;
    private Map<Region, ChampionMasteryApi> championMasteryApiByRegion;

    @lombok.experimental.Tolerate
    public ChampionMasteryService(RegionApiProvider regionApiProvider) {
        Map<Region, Retrofit> retrofitByRegion = regionApiProvider.getRetrofitByRegion();
        this.apiKey = regionApiProvider.getApiKey();
        this.championMasteryApiByRegion = Arrays.stream(Region.values())
                .collect(Collectors.toMap(
                        Function.identity(), region -> retrofitByRegion.get(region).create(ChampionMasteryApi.class),
                        (region1, region2) -> region1, () -> new EnumMap<>(Region.class)
                ));
    }

    /**
     * Calls League of Legends API to get all the ChampionMastery of a Summoner
     *
     * @param encryptedSummonerId of the Summoner
     * @param region              to get info from
     * @return A Single containing all the ChampionMastery of a Summoner
     */
    public Single<List<ChampionMastery>> getChampionMasteriesBySummoner(String encryptedSummonerId, Region region) {
        return this.championMasteryApiByRegion.get(region).getChampionMasteriesBySummoner(encryptedSummonerId, this.apiKey);
    }

    /**
     * Calls League of Legends API to get a Summoner's ChampionMastery over the specified Champion
     *
     * @param encryptedSummonerId of the Summoner
     * @param championId          of the Champion
     * @param region              to get info from
     * @return A Single containing the Summoner's ChampionMastery over the specified Champion
     */
    public Single<ChampionMastery> getChampionMasteryBySummoner(String encryptedSummonerId, String championId, Region region) {
        return this.championMasteryApiByRegion.get(region).getChampionMasteryBySummoner(encryptedSummonerId, championId, this.apiKey);
    }

    /**
     * Calls League of Legends API to get the Summoner's total ChampionMastery score
     *
     * @param encryptedSummonerId of the Summoner
     * @param region              to get info from
     * @return A Single containing the Summoner's total ChampionMastery score
     */
    public Single<Integer> getChampionMasteryScoreBySummoner(String encryptedSummonerId, Region region) {
        return this.championMasteryApiByRegion.get(region).getChampionMasteryScoreBySummoner(encryptedSummonerId, this.apiKey);
    }

}
