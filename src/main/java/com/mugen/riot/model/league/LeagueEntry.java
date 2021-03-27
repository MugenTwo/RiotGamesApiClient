package com.mugen.riot.model.league;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class LeagueEntry {

    int leaguePoints;
    int wins;
    int losses;
    boolean hotStreak;
    boolean veteran;
    boolean freshBlood;
    boolean inactive;
    String leagueId;
    String summonerId;
    String summonerName;
    String queueType;
    String tier;
    String rank;
    MiniSeries miniSeries;

}
