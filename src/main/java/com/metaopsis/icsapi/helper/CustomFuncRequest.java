package com.metaopsis.icsapi.helper;

/**
 * Created by tbennett on 2/8/17.
 */
public class CustomFuncRequest
{
    private String name;
    private String filename;
    private boolean active = false;
    private String xml;
    private String description = "";

    public CustomFuncRequest()
    {
    }

    public CustomFuncRequest(String name, String filename, boolean active, String xml, String description)
    {
        this.name = name;
        this.filename = filename;
        this.active = active;
        this.xml = xml;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getXml()
    {
        return xml;
    }

    public void setXml(String xml)
    {
        this.xml = xml;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "CustomFuncRequest{" +
                "name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                ", active=" + active +
                ", xml='" + xml + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
