package com.mugen.riot.model.platform;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class PlatformContent {

    String locale;
    String content;

}
