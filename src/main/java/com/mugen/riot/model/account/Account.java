package com.mugen.riot.model.account;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Account {

    String puuid;
    String gameName;
    String tagLine;

}
