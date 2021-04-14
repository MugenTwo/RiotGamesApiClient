package com.mugen.riot.model.match;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class Participant {

    int participantId;
    int championId;
    int teamId;
    int spell1Id;
    int spell2Id;
    String highestAchievedSeasonTier;
    ParticipantStats stats;
    ParticipantTimeline timeline;
    List<Rune> runes;
    List<Mastery> masteries;

}
