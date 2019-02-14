package com.metaopsis.icsapi.helper;

import java.util.Arrays;

/**
 * Created by tbennett on 11/5/16.
 */
public class ActivityMonitor {

    private String id;
    private String type;
    private String taskName;
    private String objectName;
    private int runId;
    private String startTime;
    private String endTime;
    private String executionState;
    private int failedSourceRows;
    private int successSourceRows;
    private int failedTargetRows;
    private int successTargetRows;
    private String errorMsg;
    private LogEntries[] entries;
    private String agentId;
    private String runtimeEnvironmentId;

    public ActivityMonitor() {
    }

    public ActivityMonitor(String id, String type, String taskName, String objectName, int runId, String startTime, String endTime, String executionState, int failedSourceRows, int successSourceRows, int failedTargetRows, int successTargetRows, String errorMsg, LogEntries[] entries, String agentId, String runtimeEnvironmentId) {
        this.id = id;
        this.type = type;
        this.taskName = taskName;
        this.objectName = objectName;
        this.runId = runId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.executionState = executionState;
        this.failedSourceRows = failedSourceRows;
        this.successSourceRows = successSourceRows;
        this.failedTargetRows = failedTargetRows;
        this.successTargetRows = successTargetRows;
        this.errorMsg = errorMsg;
        this.entries = entries;
        this.agentId = agentId;
        this.runtimeEnvironmentId = runtimeEnvironmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExecutionState() {
        return executionState;
    }

    public void setExecutionState(String executionState) {
        this.executionState = executionState;
    }

    public int getFailedSourceRows() {
        return failedSourceRows;
    }

    public void setFailedSourceRows(int failedSourceRows) {
        this.failedSourceRows = failedSourceRows;
    }

    public int getSuccessSourceRows() {
        return successSourceRows;
    }

    public void setSuccessSourceRows(int successSourceRows) {
        this.successSourceRows = successSourceRows;
    }

    public int getFailedTargetRows() {
        return failedTargetRows;
    }

    public void setFailedTargetRows(int failedTargetRows) {
        this.failedTargetRows = failedTargetRows;
    }

    public int getSuccessTargetRows() {
        return successTargetRows;
    }

    public void setSuccessTargetRows(int successTargetRows) {
        this.successTargetRows = successTargetRows;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public LogEntries[] getEntries() {
        return entries;
    }

    public void setEntries(LogEntries[] entries) {
        this.entries = entries;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getRuntimeEnvironmentId() {
        return runtimeEnvironmentId;
    }

    public void setRuntimeEnvironmentId(String runtimeEnvironmentId) {
        this.runtimeEnvironmentId = runtimeEnvironmentId;
    }

    @Override
    public String toString() {
        return "ActivityMonitor{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", taskName='" + taskName + '\'' +
                ", objectName='" + objectName + '\'' +
                ", runId=" + runId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", executionState='" + executionState + '\'' +
                ", failedSourceRows=" + failedSourceRows +
                ", successSourceRows=" + successSourceRows +
                ", failedTargetRows=" + failedTargetRows +
                ", successTargetRows=" + successTargetRows +
                ", errorMsg='" + errorMsg + '\'' +
                ", entries=" + Arrays.toString(entries) +
                ", agentId='" + agentId + '\'' +
                ", runtimeEnvironmentId='" + runtimeEnvironmentId + '\'' +
                '}';
    }
}
