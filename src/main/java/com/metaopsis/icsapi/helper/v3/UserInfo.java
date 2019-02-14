package com.metaopsis.icsapi.helper.v3;

public class UserInfo {
    private String sessionId;
    private String id;
    private String name;
    private String parentOrgId;
    private String orgId;
    private String orgName;
    private String status;

    public UserInfo() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sessionId='" + sessionId + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentOrgId='" + parentOrgId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}