package com.metaopsis.icsapi.helper;

/**
 * Created by tombennett on 8/15/17.
 */
public class ConnectionParameters
{
    private String agentId;
    private String agentGroupId;
    private String orgId;

    public ConnectionParameters()
    {
    }

    public ConnectionParameters(String agentId, String agentGroupId, String orgId)
    {
        this.agentId = agentId;
        this.agentGroupId = agentGroupId;
        this.orgId = orgId;
    }

    public String getAgentId()
    {
        return agentId;
    }

    public void setAgentId(String agentId)
    {
        this.agentId = agentId;
    }

    public String getAgentGroupId()
    {
        return agentGroupId;
    }

    public void setAgentGroupId(String agentGroupId)
    {
        this.agentGroupId = agentGroupId;
    }

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    @Override
    public String toString()
    {
        return "ConnectionParameters{" +
                "agentId='" + agentId + '\'' +
                ", agentGroupId='" + agentGroupId + '\'' +
                ", orgId='" + orgId + '\'' +
                '}';
    }
}
