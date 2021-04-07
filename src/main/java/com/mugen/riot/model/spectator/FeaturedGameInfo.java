package com.mugen.riot.model.spectator;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class FeaturedGameInfo {

    long gameLength;
    long mapId;
    long gameId;
    long gameQueueConfigId;
    long gameStartTime;
    String gameMode;
    String gameType;
    String platformId;
    Observer observer;
    List<BannedChampion> bannedChampions;
    List<Participant> participants;

}
