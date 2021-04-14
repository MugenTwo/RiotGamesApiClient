package com.mugen.riot.model.match;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class Match {

    int queueId;
    int seasonId;
    int mapId;
    long gameId;
    long gameDuration;
    long gameCreation;
    String gameType;
    String platformId;
    String gameVersion;
    String gameMode;
    List<TeamStats> teams;
    List<Participant> participants;
    List<ParticipantIdentity> participantIdentities;

}
