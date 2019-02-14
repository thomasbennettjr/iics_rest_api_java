package com.metaopsis.icsapi.dom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class mtTaskParameterSource implements ImtTaskParameter
{
    @JsonProperty("@type")
    private String type = "mtTaskParameter";
    private String name;
    @JsonProperty("type")
    private String paramType;
    private String label;
    private String description;
    private String sourceConnectionId;

}
