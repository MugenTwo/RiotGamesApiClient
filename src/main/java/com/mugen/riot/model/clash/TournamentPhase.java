package com.mugen.riot.model.clash;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class TournamentPhase {

    int id;
    long registrationTime;
    long startTime;
    boolean cancelled;

}
