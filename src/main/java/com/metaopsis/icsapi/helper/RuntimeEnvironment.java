package com.metaopsis.icsapi.helper;

public class RuntimeEnvironment
{
    private String id;
    private String orgId;
    private String name;

    public RuntimeEnvironment()
    {
    }

    public RuntimeEnvironment(String id, String orgId, String name)
    {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
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


    @Override
    public String toString()
    {
        return "RuntimeEnvironment{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
