package com.mugen.riot.model.spectator;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class BannedChampion {

    int pickTurn;
    long championId;
    long teamId;

}
