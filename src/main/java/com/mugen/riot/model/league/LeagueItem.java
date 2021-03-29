package com.mugen.riot.model.league;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class LeagueItem {

    int wins;
    int leaguePoints;
    int losses;
    boolean freshBlood;
    boolean inactive;
    boolean veteran;
    boolean hotStreak;
    String summonerName;
    String rank;
    String summonerId;
    List<MiniSeries> miniSeries;

}
