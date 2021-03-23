package com.mugen.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class Champion {

    List<Integer> freeChampionIdsForNewPlayers;
    List<Integer> freeChampionIds;
    int maxNewPlayerLevel;

}
