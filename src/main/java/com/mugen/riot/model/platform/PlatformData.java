package com.mugen.riot.model.platform;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class PlatformData {

    String id;
    String name;
    List<String> locales;
    List<PlatformStatus> maintenances;
    List<PlatformStatus> incidents;

}
