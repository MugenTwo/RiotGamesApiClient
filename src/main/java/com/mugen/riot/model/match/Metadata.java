package com.mugen.riot.model.match;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class Metadata {

    String dataVersion;
    String matchId;
    List<String> participants;

}
