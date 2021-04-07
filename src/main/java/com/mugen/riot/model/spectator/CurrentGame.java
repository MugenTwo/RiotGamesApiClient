package com.mugen.riot.model.spectator;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class CurrentGame {

    long gameId;
    long gameStartTime;
    long mapId;
    long gameLength;
    long gameQueueConfigId;
    String gameType;
    String platformId;
    String gameMode;
    Observer observer;
    List<BannedChampion> bannedChampions;
    List<CurrentGameParticipant> participants;

}
