package com.metaopsis.icsapi.helper;

import java.util.Arrays;

public class Mapping {
	private String id;
	private String name;
	private String templateId;
	private Parameters[] parameters;
	
	public Mapping() {}

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
	
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	public Parameters[] getParameters() {
		return parameters;
	}

	public void setParameters(Parameters[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "Mapping [id=" + id + ", name=" + name + ", templateId=" + templateId + ", parameters="
				+ Arrays.toString(parameters) + "]";
	}

}
