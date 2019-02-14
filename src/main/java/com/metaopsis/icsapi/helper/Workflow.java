package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by tbennett on 2/7/17.
 */
public class Workflow
{
    @JsonProperty("@type")
    private String xtype = "workflow";
    private String id;
    private String name;
    private String scheduleId = "";
    private WorkflowTask[] tasks;

    public Workflow()
    {
    }

    public Workflow(String xtype, String id, String name, String scheduleId, WorkflowTask[] tasks)
    {
        this.xtype = xtype;
        this.id = id;
        this.name = name;
        this.scheduleId = scheduleId;
        this.tasks = tasks;
    }

    public String getXtype()
    {
        return xtype;
    }

    public void setXtype(String xtype)
    {
        this.xtype = xtype;
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getScheduleId()
    {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId)
    {
        this.scheduleId = scheduleId;
    }

    public WorkflowTask[] getTasks()
    {
        return tasks;
    }

    public void setTasks(WorkflowTask[] tasks)
    {
        this.tasks = tasks;
    }

	@Override
	public String toString() {
		return "Workflow [xtype=" + xtype + ", id=" + id + ", name=" + name + ", scheduleId=" + scheduleId + ", tasks="
				+ Arrays.toString(tasks) + "]";
	}

    
}

