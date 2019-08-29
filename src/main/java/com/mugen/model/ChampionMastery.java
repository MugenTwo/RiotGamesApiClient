package com.mugen.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class ChampionMastery {

    private boolean chestGranted;
    private int championLevel;
    private int championPoints;
    private long championId;
    private long championPointsUntilNextLevel;
    private long lastPlayTime;
    private int tokensEarned;
    private long championPointsSinceLastLevel;
    private String summonerId;

}
