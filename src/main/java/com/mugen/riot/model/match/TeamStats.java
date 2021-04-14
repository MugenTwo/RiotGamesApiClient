package com.mugen.riot.model.match;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class TeamStats {

    int towerKills;
    int riftHeraldKills;
    int dominionVictoryScore;
    int dragonKills;
    int baronKills;
    int vilemawKills;
    int teamId;
    boolean firstBlood;
    boolean firstBaron;
    boolean firstDragon;
    boolean firstInhibitor;
    boolean firstTower;
    boolean firstRiftHerald;
    String win;
    List<TeamBans> bans;

}
