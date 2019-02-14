package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 2/7/17.
 */
public class CustomFunc
{
    @JsonProperty("@type")
    private final String xtype = "customFunc";
    private String id;
    private String orgId;
    private String name;
    private String mappletName;
    private boolean active;
    private String mappletXmlFile;
    private String category;

    public CustomFunc()
    {
    }

    public CustomFunc(String id, String orgId, String name, String mappletName, boolean active, String mappletXmlFile, String category)
    {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.mappletName = mappletName;
        this.active = active;
        this.mappletXmlFile = mappletXmlFile;
        this.category = category;
    }


    public String getXtype()
    {
        return xtype;
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

    public String getMappletName()
    {
        return mappletName;
    }

    public void setMappletName(String mappletName)
    {
        this.mappletName = mappletName;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getMappletXmlFile()
    {
        return mappletXmlFile;
    }

    public void setMappletXmlFile(String mappletXmlFile)
    {
        this.mappletXmlFile = mappletXmlFile;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "CustomFunc{" +
                "xtype='" + xtype + '\'' +
                ", id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", mappletName='" + mappletName + '\'' +
                ", active=" + active +
                ", mappletXmlFile='" + mappletXmlFile + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
