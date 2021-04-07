package com.mugen.riot.model.spectator;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class Perks {

    long perkStyle;
    long perkSubStyle;
    List<Long> perkIds;

}
