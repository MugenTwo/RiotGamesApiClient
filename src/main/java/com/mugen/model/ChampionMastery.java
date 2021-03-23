package com.mugen.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class ChampionMastery {

    boolean chestGranted;
    int championLevel;
    int championPoints;
    long championId;
    long championPointsUntilNextLevel;
    long lastPlayTime;
    int tokensEarned;
    long championPointsSinceLastLevel;
    String summonerId;

}
