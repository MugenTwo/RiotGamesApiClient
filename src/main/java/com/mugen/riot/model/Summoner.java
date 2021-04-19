package com.mugen.riot.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Summoner {

    int profileIconId;
    long summonerLevel;
    long revisionDate;
    String name;
    String puuid;
    String id;
    String accountId;

}
