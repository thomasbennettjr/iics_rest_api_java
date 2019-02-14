package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 2/7/17.
 */
public class OracleConnection implements IConnection
{
    @JsonProperty("@type")
    private final String xtype = "connection";
    private String id;
    private String orgId;
    private String name;
    private String description;
    private String agentId;
    private String runtimeEnvironmentId;
    private String type = "Oracle";
    private int port;
    private int timeout = 60;
    private String username;
    private String password;
    private String host;
    private String database;
    private String schema;
    private String codepage;
    private String adjustedJdbcHostName;
    private String shortDescription = "";

    public OracleConnection()
    {
    }

    public OracleConnection(String id, String orgId, String name, String description, String agentId, String runtimeEnvironmentId, String type, int port, int timeout, String username, String password, String host, String database, String schema, String codepage, String adjustedJdbcHostName, String shortDescription)
    {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.description = description;
        this.agentId = agentId;
        this.runtimeEnvironmentId = runtimeEnvironmentId;
        this.type = type;
        this.port = port;
        this.timeout = timeout;
        this.username = username;
        this.password = password;
        this.host = host;
        this.database = database;
        this.schema = schema;
        this.codepage = codepage;
        this.adjustedJdbcHostName = adjustedJdbcHostName;
        this.shortDescription = shortDescription;
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

    public int getTimeout()
    {
        return timeout;
    }

    public void setTimeout(int timeout)
    {
        this.timeout = timeout;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

    public String getSchema()
    {
        return schema;
    }

    public void setSchema(String schema)
    {
        this.schema = schema;
    }

    public String getCodepage()
    {
        return codepage;
    }

    public void setCodepage(String codepage)
    {
        this.codepage = codepage;
    }

    public String getAdjustedJdbcHostName()
    {
        return adjustedJdbcHostName;
    }

    public void setAdjustedJdbcHostName(String adjustedJdbcHostName)
    {
        this.adjustedJdbcHostName = adjustedJdbcHostName;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString()
    {
        return "OracleConnection{" +
                "xtype='" + xtype + '\'' +
                ", id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", agentId='" + agentId + '\'' +
                ", runtimeEnvironmentId='" + runtimeEnvironmentId + '\'' +
                ", type='" + type + '\'' +
                ", port=" + port +
                ", timeout=" + timeout +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", database='" + database + '\'' +
                ", schema='" + schema + '\'' +
                ", codepage='" + codepage + '\'' +
                ", adjustedJdbcHostName='" + adjustedJdbcHostName + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
