package com.mugen.riot.model.clash;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class ClashTeam {

    int tournamentId;
    int iconId;
    int tier;
    String id;
    String name;
    String captain;
    String abbreviation;
    List<ClashPlayer> players;

}
