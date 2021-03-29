package com.mugen.riot.model.league;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class LeagueList {

    String leagueId;
    String tier;
    String name;
    String queue;
    List<LeagueItem> entries;

}
