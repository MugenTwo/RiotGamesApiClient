package com.mugen.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Summoner {

    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private long revisionDate;
    private String id;
    private String accountId;

}
