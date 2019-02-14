package com.metaopsis.icsapi.dom;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metaopsis.icsapi.helper.Parameters;

public class MappingConfigurationTaskRequest
{
    @JsonProperty("@type")
    private String type = "mtTask";
    private String orgId;
    private String name;
    private String description;
    private String runtimeEnvironmentId;
    private String mappingId;
    private Parameters[] parameters;
}
