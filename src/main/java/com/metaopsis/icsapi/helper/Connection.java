package com.metaopsis.icsapi.helper;

/**
 * Created by tombennett on 8/15/17.
 */
public class Connection
{
    private String id;
    private String orgId;
    private String name;
    private String createTime;
    private String updateTime;
    private String createdBy;
    private String updatedBy;
    private String agentId;
    private String runtimeEnvironmentId;
    private String dateFormat;
    private String database;
    private String codepage;
    private String type;
    private int port;
    private String majorUpdateTime;
    private int timeout;
    private String instanceName;
    private String serviceUrl;
    private String username;
    private String password;
    private String securityToken;
    private String shortDescription;
    private String host;
    private String adjustedJdbcHostName;
    private String schema;
    private ConnectionParameters connParams;

    public Connection()
    {
    }

    public Connection(String id, String orgId, String name, String createTime, String updateTime, String createdBy, String updatedBy, String agentId, String runtimeEnvironmentId, String dateFormat, String database, String codepage, String type, int port, String majorUpdateTime, int timeout, String instanceName, String serviceUrl, String username, String password, String securityToken, String shortDescription, String host, String adjustedJdbcHostName, String schema, ConnectionParameters connParams)
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
        this.dateFormat = dateFormat;
        this.database = database;
        this.codepage = codepage;
        this.type = type;
        this.port = port;
        this.majorUpdateTime = majorUpdateTime;
        this.timeout = timeout;
        this.instanceName = instanceName;
        this.serviceUrl = serviceUrl;
        this.username = username;
        this.password = password;
        this.securityToken = securityToken;
        this.shortDescription = shortDescription;
        this.host = host;
        this.adjustedJdbcHostName = adjustedJdbcHostName;
        this.schema = schema;
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

    public String getDateFormat()
    {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
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

    public String getInstanceName()
    {
        return instanceName;
    }

    public void setInstanceName(String instanceName)
    {
        this.instanceName = instanceName;
    }

    public String getServiceUrl()
    {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl)
    {
        this.serviceUrl = serviceUrl;
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

    public String getSecurityToken()
    {
        return securityToken;
    }

    public void setSecurityToken(String securityToken)
    {
        this.securityToken = securityToken;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
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

    public ConnectionParameters getConnParams()
    {
        return connParams;
    }

    public void setConnParams(ConnectionParameters connParams)
    {
        this.connParams = connParams;
    }

    @Override
    public String toString()
    {
        return "Connection{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", agentId='" + agentId + '\'' +
                ", runtimeEnvironmentId='" + runtimeEnvironmentId + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ", database='" + database + '\'' +
                ", codepage='" + codepage + '\'' +
                ", type='" + type + '\'' +
                ", port=" + port +
                ", majorUpdateTime='" + majorUpdateTime + '\'' +
                ", timeout=" + timeout +
                ", instanceName='" + instanceName + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", securityToken='" + securityToken + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", host='" + host + '\'' +
                ", adjustedJdbcHostName='" + adjustedJdbcHostName + '\'' +
                ", schema='" + schema + '\'' +
                ", connParams=" + connParams +
                '}';
    }
}
