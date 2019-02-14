package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 2/7/17.
 */
public class WorkflowTask
{
    @JsonProperty("@type")
    private String xtype = "workflowTask";
    private String taskId;
    private String type = "MTT";
    private String name;
    private boolean stopOnError = false;
    private boolean stopOnWarning = false;

    public WorkflowTask()
    {
    }

    public WorkflowTask(String xtype, String taskId, String type, String name, boolean stopOnError, boolean stopOnWarning)
    {
        this.xtype = xtype;
        this.taskId = taskId;
        this.type = type;
        this.name = name;
        this.stopOnError = stopOnError;
        this.stopOnWarning = stopOnWarning;
    }


    public String getXtype()
    {
        return xtype;
    }

    public void setXtype(String xtype)
    {
        this.xtype = xtype;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isStopOnError()
    {
        return stopOnError;
    }

    public void setStopOnError(boolean stopOnError)
    {
        this.stopOnError = stopOnError;
    }

    public boolean isStopOnWarning()
    {
        return stopOnWarning;
    }

    public void setStopOnWarning(boolean stopOnWarning)
    {
        this.stopOnWarning = stopOnWarning;
    }

    @Override
    public String toString()
    {
        return "WorkflowTask{" +
                "xtype='" + xtype + '\'' +
                ", taskId='" + taskId + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", stopOnError=" + stopOnError +
                ", stopOnWarning=" + stopOnWarning +
                '}';
    }
}
