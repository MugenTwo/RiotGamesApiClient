package com.mugen.riot.model.platform;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class PlatformUpdate {

    int id;
    boolean publish;
    String author;
    @SerializedName(value = "created_at")
    String createdAt;
    @SerializedName(value = "updated_at")
    String updatedAt;
    @SerializedName(value = "publish_locations")
    List<String> publishLocations;
    List<PlatformContent> translations;

}
