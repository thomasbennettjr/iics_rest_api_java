package com.metaopsis.icsapi.helper;

/**
 * Created by tbennett on 11/5/16.
 */
public class AclEntries {
    private String objectType;
    private boolean createPermission;
    private boolean readPermission;
    private boolean updatePermission;
    private boolean deletePermission;
    private boolean executePermission;
    private boolean adminPermission;
    private String userGroupId;

    public AclEntries() {
    }

    public AclEntries(String objectType, boolean createPermission, boolean readPermission, boolean updatePermission, boolean deletePermission, boolean executePermission, boolean adminPermission, String userGroupId) {
        this.objectType = objectType;
        this.createPermission = createPermission;
        this.readPermission = readPermission;
        this.updatePermission = updatePermission;
        this.deletePermission = deletePermission;
        this.executePermission = executePermission;
        this.adminPermission = adminPermission;
        this.userGroupId = userGroupId;
    }


    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public boolean isCreatePermission() {
        return createPermission;
    }

    public void setCreatePermission(boolean createPermission) {
        this.createPermission = createPermission;
    }

    public boolean isReadPermission() {
        return readPermission;
    }

    public void setReadPermission(boolean readPermission) {
        this.readPermission = readPermission;
    }

    public boolean isUpdatePermission() {
        return updatePermission;
    }

    public void setUpdatePermission(boolean updatePermission) {
        this.updatePermission = updatePermission;
    }

    public boolean isDeletePermission() {
        return deletePermission;
    }

    public void setDeletePermission(boolean deletePermission) {
        this.deletePermission = deletePermission;
    }

    public boolean isExecutePermission() {
        return executePermission;
    }

    public void setExecutePermission(boolean executePermission) {
        this.executePermission = executePermission;
    }

    public boolean isAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(boolean adminPermission) {
        this.adminPermission = adminPermission;
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    @Override
    public String toString() {
        return "AclEntries{" +
                "objectType='" + objectType + '\'' +
                ", createPermission=" + createPermission +
                ", readPermission=" + readPermission +
                ", updatePermission=" + updatePermission +
                ", deletePermission=" + deletePermission +
                ", executePermission=" + executePermission +
                ", adminPermission=" + adminPermission +
                ", userGroupId='" + userGroupId + '\'' +
                '}';
    }
}
