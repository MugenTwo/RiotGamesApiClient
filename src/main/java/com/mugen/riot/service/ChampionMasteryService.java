package com.mugen.riot.service;

import com.mugen.riot.RegionApiProvider;
import com.mugen.riot.api.ChampionMasteryApi;
import com.mugen.riot.model.ChampionMastery;
import com.mugen.riot.Region;
import io.reactivex.BackpressureStrategy;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.reactivestreams.Publisher;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ChampionMasteryService {

    private final String apiKey;
    private final Map<Region, ChampionMasteryApi> championMasteryApiByRegion;

    public ChampionMasteryService(RegionApiProvider regionApiProvider) {
        this.apiKey = regionApiProvider.getApiKey();
        this.championMasteryApiByRegion = regionApiProvider.generateApiByRegion(ChampionMasteryApi.class);
    }

    /**
     * Calls League of Legends API to get all the ChampionMastery of a Summoner
     *
     * @param encryptedSummonerId of the Summoner
     * @param region              to get info from
     * @return A Publisher containing all the ChampionMastery of a Summoner
     */
    public Publisher<List<ChampionMastery>> getChampionMasteriesBySummoner(String encryptedSummonerId, Region region) {
        return this.championMasteryApiByRegion.get(region).getChampionMasteriesBySummoner(encryptedSummonerId, this.apiKey)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    /**
     * Calls League of Legends API to get a Summoner's ChampionMastery over the specified Champion
     *
     * @param encryptedSummonerId of the Summoner
     * @param championId          of the Champion
     * @param region              to get info from
     * @return A Publisher containing the Summoner's ChampionMastery over the specified Champion
     */
    public Publisher<ChampionMastery> getChampionMasteryBySummoner(String encryptedSummonerId, String championId, Region region) {
        return this.championMasteryApiByRegion.get(region).getChampionMasteryBySummoner(encryptedSummonerId, championId, this.apiKey)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    /**
     * Calls League of Legends API to get the Summoner's total ChampionMastery score
     *
     * @param encryptedSummonerId of the Summoner
     * @param region              to get info from
     * @return A Publisher containing the Summoner's total ChampionMastery score
     */
    public Publisher<Integer> getChampionMasteryScoreBySummoner(String encryptedSummonerId, Region region) {
        return this.championMasteryApiByRegion.get(region).getChampionMasteryScoreBySummoner(encryptedSummonerId, this.apiKey)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

}
