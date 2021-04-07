package com.mugen.riot.model.spectator;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Participant {

    long spell1Id;
    long spell2Id;
    long profileIconId;
    long championId;
    long teamId;
    boolean bot;
    String summonerName;

}
