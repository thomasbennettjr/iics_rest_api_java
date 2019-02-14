package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 11/5/16.
 */

public class Job {
    @JsonProperty("@type")
    private final String type = "job";
    private String taskId = null;
    //private String taskName;
    private String taskFederatedId;
    private String taskType;
    private String callbackURL = "";
    private int runId = 0;

    public String getTaskFederatedId() {
        return taskFederatedId;
    }

    public void setTaskFederatedId(String taskFederatedId) {
        this.taskFederatedId = taskFederatedId;
    }

    public Job() {
    }

    public Job(String taskFederatedId, String taskType, String callbackURL, int runId) {
        this.taskFederatedId = taskFederatedId;
        this.taskType = taskType;
        this.callbackURL = callbackURL;
        this.runId = runId;
    }

    /*
    public Job(String taskId, String taskName, String taskType, String callbackURL, int runId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskType = taskType;
        this.callbackURL = callbackURL;
        this.runId = runId;
    }
    */

    public String getType() {
        return type;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    /*
        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }
    */
    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "type='" + type + '\'' +
//                ", taskId='" + taskId + '\'' +
//                ", taskName='" + taskName + '\'' +
                ", taskType='" + taskType + '\'' +
                ", callbackURL='" + callbackURL + '\'' +
                ", runId=" + runId +
                '}';
    }
}
