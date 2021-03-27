package com.mugen.riot.model.champion;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class ChampionRotation {

    List<Integer> freeChampionIdsForNewPlayers;
    List<Integer> freeChampionIds;
    int maxNewPlayerLevel;

}
