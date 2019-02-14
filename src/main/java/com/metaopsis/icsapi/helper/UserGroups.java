package com.metaopsis.icsapi.helper;

import java.util.Arrays;

/**
 * Created by tbennett on 11/5/16.
 */
public class UserGroups {
    private String id;
    private String orgId;
    private String name;
    private String createTime;
    private String updateTime;
    private String createdBy;
    private String updatedBy;
    private AclEntries[] aclEntries;

    public UserGroups() {
    }

    public UserGroups(String id, String orgId, String name, String createTime, String updateTime, String createdBy, String updatedBy, AclEntries[] aclEntries) {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.aclEntries = aclEntries;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public AclEntries[] getAclEntries() {
        return aclEntries;
    }

    public void setAclEntries(AclEntries[] aclEntries) {
        this.aclEntries = aclEntries;
    }

    @Override
    public String toString() {
        return "UserGroups{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", aclEntries=" + Arrays.toString(aclEntries) +
                '}';
    }
}
