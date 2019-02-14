package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameters {
	@JsonProperty("@type")
	private String type = "mtTaskParameterSource";
	private String name;
	@JsonProperty("type")
	private String paramType;
	private String label;
	private String description;
	private String sourceConnectionId;
	private String sourceObject;
	private String customQuery;
	private String targetObject;
	private String targetConnectionId;
	private String lookupConnectionId;
	private String lookupObject;
	
	public Parameters() {}


	
	
}
