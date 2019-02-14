package com.metaopsis.icsapi.helper;

import java.util.Arrays;

public class MappingConfigurationTask {
	private String id;
	private String name;
	private String mappingId;
	private Parameters[] parameters;
	
	public MappingConfigurationTask() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}

	public Parameters[] getParameters() {
		return parameters;
	}

	public void setParameters(Parameters[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "MappingConfigurationTask [id=" + id + ", name=" + name + ", mappingId=" + mappingId + ", parameters="
				+ Arrays.toString(parameters) + "]";
	}
	
	
}
