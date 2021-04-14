package com.mugen.riot.model.match;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class ParticipantIdentity {

    int participantId;
    MatchPlayer player;

}
