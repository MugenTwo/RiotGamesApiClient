package com.mugen.riot.model.platform;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@Value
public class PlatformStatus {

    int id;
    @SerializedName(value = "maintenance_status")
    String maintenanceStatus;
    @SerializedName(value = "incident_severity")
    String incidentSeverity;
    @SerializedName(value = "created_at")
    String createdAt;
    @SerializedName(value = "archive_at")
    String archiveAt;
    @SerializedName(value = "updated_at")
    String updatedAt;
    List<PlatformContent> titles;
    List<PlatformUpdate> updates;
    List<String> platforms;

}
