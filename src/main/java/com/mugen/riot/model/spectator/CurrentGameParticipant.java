package com.mugen.riot.model.spectator;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class CurrentGameParticipant {

    long championId;
    long profileIconId;
    long teamId;
    long spell1Id;
    long spell2Id;
    boolean bot;
    String summonerName;
    String summonerId;
    Perks perks;
    List<GameCustomizationObject> gameCustomizationObjects;

}
