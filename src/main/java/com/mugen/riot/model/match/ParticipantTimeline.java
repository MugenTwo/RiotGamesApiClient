package com.mugen.riot.model.match;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Builder(toBuilder = true)
@Value
public class ParticipantTimeline {

    int participantId;
    String role;
    String lane;
    Map<String, Double> csDiffPerMinDeltas;
    Map<String, Double> damageTakenPerMinDeltas;
    Map<String, Double> damageTakenDiffPerMinDeltas;
    Map<String, Double> xpPerMinDeltas;
    Map<String, Double> xpDiffPerMinDeltas;
    Map<String, Double> creepsPerMinDeltas;
    Map<String, Double> goldPerMinDeltas;

}
