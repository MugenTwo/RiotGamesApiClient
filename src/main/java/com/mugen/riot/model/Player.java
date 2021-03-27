package com.mugen.riot.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Player {

    String summonerId;
    String teamId;
    String position;
    String role;

}
