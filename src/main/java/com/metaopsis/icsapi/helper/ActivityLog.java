package com.metaopsis.icsapi.helper;

import java.util.Arrays;

/**
 * Created by tbennett on 11/5/16.
 */
public class ActivityLog {

    private String id;
    private String type;
    private String objectId;
    private String objectName;
    private int runId;
    private String startTime;
    private String endTime;
    private String startTimeUtc;
    private String endTimeUtc;
    private int state;
    private int failedSourceRows;
    private int successSourceRows;
    private int failedTargetRows;
    private int successTargetRows;
    private String errorMsg;
    private String startedBy;
    private String runContextType;
    private int totalSuccessRows;
    private int totalFailedRows;
    private boolean stopOnError;
    private boolean hasStopOnErrorRecord;
    private LogEntries[] entries;

    public ActivityLog() {
    }

    public ActivityLog(String id, String type, String objectId, String objectName, int runId, String startTime, String endTime, String startTimeUtc, String endTimeUtc, int state, int failedSourceRows, int successSourceRows, int failedTargetRows, int successTargetRows, String errorMsg, String startedBy, String runContextType, int totalSuccessRows, int totalFailedRows, boolean stopOnError, boolean hasStopOnErrorRecord, LogEntries[] entries) {
        this.id = id;
        this.type = type;
        this.objectId = objectId;
        this.objectName = objectName;
        this.runId = runId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startTimeUtc = startTimeUtc;
        this.endTimeUtc = endTimeUtc;
        this.state = state;
        this.failedSourceRows = failedSourceRows;
        this.successSourceRows = successSourceRows;
        this.failedTargetRows = failedTargetRows;
        this.successTargetRows = successTargetRows;
        this.errorMsg = errorMsg;
        this.startedBy = startedBy;
        this.runContextType = runContextType;
        this.totalSuccessRows = totalSuccessRows;
        this.totalFailedRows = totalFailedRows;
        this.stopOnError = stopOnError;
        this.hasStopOnErrorRecord = hasStopOnErrorRecord;
        this.entries = entries;
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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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

    public String getStartTimeUtc() {
        return startTimeUtc;
    }

    public void setStartTimeUtc(String startTimeUtc) {
        this.startTimeUtc = startTimeUtc;
    }

    public String getEndTimeUtc() {
        return endTimeUtc;
    }

    public void setEndTimeUtc(String endTimeUtc) {
        this.endTimeUtc = endTimeUtc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getStartedBy() {
        return startedBy;
    }

    public void setStartedBy(String startedBy) {
        this.startedBy = startedBy;
    }

    public String getRunContextType() {
        return runContextType;
    }

    public void setRunContextType(String runContextType) {
        this.runContextType = runContextType;
    }

    public int getTotalSuccessRows() {
        return totalSuccessRows;
    }

    public void setTotalSuccessRows(int totalSuccessRows) {
        this.totalSuccessRows = totalSuccessRows;
    }

    public int getTotalFailedRows() {
        return totalFailedRows;
    }

    public void setTotalFailedRows(int totalFailedRows) {
        this.totalFailedRows = totalFailedRows;
    }

    public boolean isStopOnError() {
        return stopOnError;
    }

    public void setStopOnError(boolean stopOnError) {
        this.stopOnError = stopOnError;
    }

    public boolean isHasStopOnErrorRecord() {
        return hasStopOnErrorRecord;
    }

    public void setHasStopOnErrorRecord(boolean hasStopOnErrorRecord) {
        this.hasStopOnErrorRecord = hasStopOnErrorRecord;
    }

    public LogEntries[] getEntries() {
        return entries;
    }

    public void setEntries(LogEntries[] entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", objectId='" + objectId + '\'' +
                ", objectName='" + objectName + '\'' +
                ", runId=" + runId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startTimeUtc='" + startTimeUtc + '\'' +
                ", endTimeUtc='" + endTimeUtc + '\'' +
                ", state=" + state +
                ", failedSourceRows=" + failedSourceRows +
                ", successSourceRows=" + successSourceRows +
                ", failedTargetRows=" + failedTargetRows +
                ", successTargetRows=" + successTargetRows +
                ", errorMsg='" + errorMsg + '\'' +
                ", startedBy='" + startedBy + '\'' +
                ", runContextType='" + runContextType + '\'' +
                ", totalSuccessRows=" + totalSuccessRows +
                ", totalFailedRows=" + totalFailedRows +
                ", stopOnError=" + stopOnError +
                ", hasStopOnErrorRecord=" + hasStopOnErrorRecord +
                ", entries=" + Arrays.toString(entries) +
                '}';
    }
}
