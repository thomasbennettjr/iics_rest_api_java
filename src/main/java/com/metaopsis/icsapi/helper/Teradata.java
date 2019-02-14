package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tombennett on 8/15/17.
 */
public class Teradata implements IConnection
{
    @JsonProperty("@type")
    private final String otype = "connection";
    private String id;
    private String orgId;
    private String name;
    private String createTime;
    private String updateTime;
    private String createdBy;
    private String updatedBy;
    private String agentId;
    private String runtimeEnvironmentId;
    private String instanceName;
    private String type = "TOOLKIT";
    private int port;
    private String majorUpdateTime;
    private int timeout;
    private TeradataConnParams connParams;

    public Teradata()
    {
    }

    public Teradata(String id, String orgId, String name, String createTime, String updateTime, String createdBy, String updatedBy, String agentId, String runtimeEnvironmentId, String instanceName, String type, int port, String majorUpdateTime, int timeout, TeradataConnParams connParams)
    {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.agentId = agentId;
        this.runtimeEnvironmentId = runtimeEnvironmentId;
        this.instanceName = instanceName;
        this.type = type;
        this.port = port;
        this.majorUpdateTime = majorUpdateTime;
        this.timeout = timeout;
        this.connParams = connParams;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public String getAgentId()
    {
        return agentId;
    }

    public void setAgentId(String agentId)
    {
        this.agentId = agentId;
    }

    public String getRuntimeEnvironmentId()
    {
        return runtimeEnvironmentId;
    }

    public void setRuntimeEnvironmentId(String runtimeEnvironmentId)
    {
        this.runtimeEnvironmentId = runtimeEnvironmentId;
    }

    public String getInstanceName()
    {
        return instanceName;
    }

    public void setInstanceName(String instanceName)
    {
        this.instanceName = instanceName;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getMajorUpdateTime()
    {
        return majorUpdateTime;
    }

    public void setMajorUpdateTime(String majorUpdateTime)
    {
        this.majorUpdateTime = majorUpdateTime;
    }

    public int getTimeout()
    {
        return timeout;
    }

    public void setTimeout(int timeout)
    {
        this.timeout = timeout;
    }

    public TeradataConnParams getConnParams()
    {
        return connParams;
    }

    public void setConnParams(TeradataConnParams connParams)
    {
        this.connParams = connParams;
    }

    @Override
    public String toString()
    {
        return "Teradata{" +
                "otype='" + otype + '\'' +
                ", id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", agentId='" + agentId + '\'' +
                ", runtimeEnvironmentId='" + runtimeEnvironmentId + '\'' +
                ", instanceName='" + instanceName + '\'' +
                ", type='" + type + '\'' +
                ", port=" + port +
                ", majorUpdateTime='" + majorUpdateTime + '\'' +
                ", timeout=" + timeout +
                ", connParams=" + connParams +
                '}';
    }
}
