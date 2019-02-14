package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 2/7/17.
 */
public class Scheduler
{
    @JsonProperty("@type")
    private final String xtype = "schedule";
    private String orgId;
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private String interval;
    private int frequency;
    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thu;
    private boolean fri;
    private boolean sat;
    private boolean sun;
    private boolean weekDay;
    private int dayOfMonth;
    private String weekOfMonth;
    private String dayOfWeek;
    private String timeZoneId;

    public Scheduler()
    {
    }

    public Scheduler(String orgId, String name, String description, String startTime, String endTime, String interval, int frequency, boolean mon, boolean tue, boolean wed, boolean thu, boolean fri, boolean sat, boolean sun, boolean weekDay, int dayOfMonth, String weekOfMonth, String dayOfWeek, String timeZoneId)
    {
        this.orgId = orgId;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.interval = interval;
        this.frequency = frequency;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.weekDay = weekDay;
        this.dayOfMonth = dayOfMonth;
        this.weekOfMonth = weekOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.timeZoneId = timeZoneId;
    }

    public String getXtype()
    {
        return xtype;
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

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getInterval()
    {
        return interval;
    }

    public void setInterval(String interval)
    {
        this.interval = interval;
    }

    public int getFrequency()
    {
        return frequency;
    }

    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    public boolean isMon()
    {
        return mon;
    }

    public void setMon(boolean mon)
    {
        this.mon = mon;
    }

    public boolean isTue()
    {
        return tue;
    }

    public void setTue(boolean tue)
    {
        this.tue = tue;
    }

    public boolean isWed()
    {
        return wed;
    }

    public void setWed(boolean wed)
    {
        this.wed = wed;
    }

    public boolean isThu()
    {
        return thu;
    }

    public void setThu(boolean thu)
    {
        this.thu = thu;
    }

    public boolean isFri()
    {
        return fri;
    }

    public void setFri(boolean fri)
    {
        this.fri = fri;
    }

    public boolean isSat()
    {
        return sat;
    }

    public void setSat(boolean sat)
    {
        this.sat = sat;
    }

    public boolean isSun()
    {
        return sun;
    }

    public void setSun(boolean sun)
    {
        this.sun = sun;
    }

    public boolean isWeekDay()
    {
        return weekDay;
    }

    public void setWeekDay(boolean weekDay)
    {
        this.weekDay = weekDay;
    }

    public int getDayOfMonth()
    {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth)
    {
        this.dayOfMonth = dayOfMonth;
    }

    public String getWeekOfMonth()
    {
        return weekOfMonth;
    }

    public void setWeekOfMonth(String weekOfMonth)
    {
        this.weekOfMonth = weekOfMonth;
    }

    public String getDayOfWeek()
    {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTimeZoneId()
    {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId)
    {
        this.timeZoneId = timeZoneId;
    }

    @Override
    public String toString()
    {
        return "Scheduler{" +
                "xtype='" + xtype + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", interval='" + interval + '\'' +
                ", frequency=" + frequency +
                ", mon=" + mon +
                ", tue=" + tue +
                ", wed=" + wed +
                ", thu=" + thu +
                ", fri=" + fri +
                ", sat=" + sat +
                ", sun=" + sun +
                ", weekDay=" + weekDay +
                ", dayOfMonth=" + dayOfMonth +
                ", weekOfMonth='" + weekOfMonth + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", timeZoneId='" + timeZoneId + '\'' +
                '}';
    }
}
