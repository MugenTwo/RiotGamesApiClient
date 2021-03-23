package com.mugen.riot.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Summoner {

    int profileIconId;
    String name;
    String puuid;
    long summonerLevel;
    long revisionDate;
    String id;
    String accountId;

}
