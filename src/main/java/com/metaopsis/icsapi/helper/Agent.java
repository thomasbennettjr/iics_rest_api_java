package com.metaopsis.icsapi.helper;

import java.util.Arrays;

/**
 * Created by tbennett on 11/7/16.
 */
public class Agent {
    private String id;
    private String orgId;
    private String name;
    private String createTime;
    private String updateTime;
    private String createdBy;
    private String updatedBy;
    private boolean active;
    private String platform;
    private String agentHost;
    private String serverUrl;
    private int proxyPort;
    private String agentVersion;
    private String upgradeStatus;
    private String spiUrl;
    private String lastUpgraded;
    private String lastUpgradeCheck;
    private String lastStatusChange;
    private String[] packages;
    private AgentConfigs[] agentConfigs;
    private String configUpdateTime;

    public Agent() {
    }


    public Agent(String id, String orgId, String name, String createTime, String updateTime, String createdBy, String updatedBy, boolean active, String platform, String agentHost, String serverUrl, int proxyPort, String agentVersion, String upgradeStatus, String spiUrl, String lastUpgraded, String lastUpgradeCheck, String lastStatusChange, String[] packages, AgentConfigs[] agentConfigs, String configUpdateTime) {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.active = active;
        this.platform = platform;
        this.agentHost = agentHost;
        this.serverUrl = serverUrl;
        this.proxyPort = proxyPort;
        this.agentVersion = agentVersion;
        this.upgradeStatus = upgradeStatus;
        this.spiUrl = spiUrl;
        this.lastUpgraded = lastUpgraded;
        this.lastUpgradeCheck = lastUpgradeCheck;
        this.lastStatusChange = lastStatusChange;
        this.packages = packages;
        this.agentConfigs = agentConfigs;
        this.configUpdateTime = configUpdateTime;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAgentHost() {
        return agentHost;
    }

    public void setAgentHost(String agentHost) {
        this.agentHost = agentHost;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getAgentVersion() {
        return agentVersion;
    }

    public void setAgentVersion(String agentVersion) {
        this.agentVersion = agentVersion;
    }

    public String getUpgradeStatus() {
        return upgradeStatus;
    }

    public void setUpgradeStatus(String upgradeStatus) {
        this.upgradeStatus = upgradeStatus;
    }

    public String getSpiUrl() {
        return spiUrl;
    }

    public void setSpiUrl(String spiUrl) {
        this.spiUrl = spiUrl;
    }

    public String getLastUpgraded() {
        return lastUpgraded;
    }

    public void setLastUpgraded(String lastUpgraded) {
        this.lastUpgraded = lastUpgraded;
    }

    public String getLastUpgradeCheck() {
        return lastUpgradeCheck;
    }

    public void setLastUpgradeCheck(String lastUpgradeCheck) {
        this.lastUpgradeCheck = lastUpgradeCheck;
    }

    public String getLastStatusChange() {
        return lastStatusChange;
    }

    public void setLastStatusChange(String lastStatusChange) {
        this.lastStatusChange = lastStatusChange;
    }

    public String[] getPackages() {
        return packages;
    }

    public void setPackages(String[] packages) {
        this.packages = packages;
    }

    public AgentConfigs[] getAgentConfigs() {
        return agentConfigs;
    }

    public void setAgentConfigs(AgentConfigs[] agentConfigs) {
        this.agentConfigs = agentConfigs;
    }

    public String getConfigUpdateTime() {
        return configUpdateTime;
    }

    public void setConfigUpdateTime(String configUpdateTime) {
        this.configUpdateTime = configUpdateTime;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", active=" + active +
                ", platform='" + platform + '\'' +
                ", agentHost='" + agentHost + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", proxyPort=" + proxyPort +
                ", agentVersion='" + agentVersion + '\'' +
                ", upgradeStatus='" + upgradeStatus + '\'' +
                ", spiUrl='" + spiUrl + '\'' +
                ", lastUpgraded='" + lastUpgraded + '\'' +
                ", lastUpgradeCheck='" + lastUpgradeCheck + '\'' +
                ", lastStatusChange='" + lastStatusChange + '\'' +
                ", packages=" + Arrays.toString(packages) +
                ", agentConfigs=" + Arrays.toString(agentConfigs) +
                ", configUpdateTime='" + configUpdateTime + '\'' +
                '}';
    }
}
