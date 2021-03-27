package com.mugen.riot.model.clash;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class Tournament {

    int id;
    int themeId;
    String nameKey;
    String nameKeySecondary;
    List<TournamentPhase> schedule;

}
