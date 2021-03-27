package com.mugen.riot.model.league;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class MiniSeries {

    int losses;
    int target;
    int wins;
    String progress;

}
