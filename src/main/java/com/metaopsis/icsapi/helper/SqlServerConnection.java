package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 2/7/17.
 */
public class SqlServerConnection  implements IConnection
{
    @JsonProperty("@type")
    private final String xtype = "connection";
    private String id;
    private String orgId;
    private String name;
    private String description;
    private String createTime;
    private String updateTime;
    private String createdBy;
    private String updatedBy;
    private String agentId;
    private String runtimeEnvironmentId;
    private String host;
    private String database;
    private String codepage;
    private String authenticationType;
    private String adjustedJdbcHostName;
    private String schema;
    private String type;
    private int port;
    private String password;
    private String username;
    private String majorUpdateTime;
    private int timeout = 60;
    private SqlServerConnParams connParams;


    public SqlServerConnection()
    {
    }

    public SqlServerConnection(String id, String orgId, String name, String description, String createTime, String updateTime, String createdBy, String updatedBy, String agentId, String runtimeEnvironmentId, String host, String database, String codepage, String authenticationType, String adjustedJdbcHostName, String schema, String type, int port, String password, String username, String majorUpdateTime, int timeout, SqlServerConnParams connParams)
    {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.agentId = agentId;
        this.runtimeEnvironmentId = runtimeEnvironmentId;
        this.host = host;
        this.database = database;
        this.codepage = codepage;
        this.authenticationType = authenticationType;
        this.adjustedJdbcHostName = adjustedJdbcHostName;
        this.schema = schema;
        this.type = type;
        this.port = port;
        this.password = password;
        this.username = username;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getDatabase()
    {
        return database;
    }

    public void setDatabase(String database)
    {
        this.database = database;
    }

    public String getCodepage()
    {
        return codepage;
    }

    public void setCodepage(String codepage)
    {
        this.codepage = codepage;
    }

    public String getAuthenticationType()
    {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType)
    {
        this.authenticationType = authenticationType;
    }

    public String getAdjustedJdbcHostName()
    {
        return adjustedJdbcHostName;
    }

    public void setAdjustedJdbcHostName(String adjustedJdbcHostName)
    {
        this.adjustedJdbcHostName = adjustedJdbcHostName;
    }

    public String getSchema()
    {
        return schema;
    }

    public void setSchema(String schema)
    {
        this.schema = schema;
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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

    public SqlServerConnParams getConnParams()
    {
        return connParams;
    }

    public void setConnParams(SqlServerConnParams connParams)
    {
        this.connParams = connParams;
    }

    @Override
    public String toString()
    {
        return "SqlServerConnection{" +
                "xtype='" + xtype + '\'' +
                ", id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", agentId='" + agentId + '\'' +
                ", runtimeEnvironmentId='" + runtimeEnvironmentId + '\'' +
                ", host='" + host + '\'' +
                ", database='" + database + '\'' +
                ", codepage='" + codepage + '\'' +
                ", authenticationType='" + authenticationType + '\'' +
                ", adjustedJdbcHostName='" + adjustedJdbcHostName + '\'' +
                ", schema='" + schema + '\'' +
                ", type='" + type + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", majorUpdateTime='" + majorUpdateTime + '\'' +
                ", timeout=" + timeout +
                ", connParams=" + connParams +
                '}';
    }
}
