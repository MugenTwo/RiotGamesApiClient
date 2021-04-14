package com.mugen.riot.model.match;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class MatchPlayer {

    int profileIcon;
    String accountId;
    String matchHistoryUri;
    String currentAccountId;
    String currentPlatformId;
    String summonerName;
    String summonerId;
    String platformId;

}
