package com.mugen.riot.model.match;

import com.google.common.annotations.Beta;
import lombok.Builder;
import lombok.Value;

@Beta
@Builder(toBuilder = true)
@Value
public class Match {

    Metadata metadata;
    MatchInfo info;

}
