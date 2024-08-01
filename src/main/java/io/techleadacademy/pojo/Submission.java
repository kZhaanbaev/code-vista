package io.techleadacademy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Submission {
    private String createTime;
    private String updateTime;
    private int submissionId;
    private int userId;
    private int taskId;
    private String taskName;
    private String instruction;
    private String code;
    private String status;
    private String moduleName;

    public Submission(int userId, int taskId, String taskName, String instruction, String code, String status, String moduleName) {
        this.userId = userId;
        this.taskId = taskId;
        this.taskName = taskName;
        this.instruction = instruction;
        this.code = code;
        this.status = status;
        this.moduleName = moduleName;
    }

    public Submission() {
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "Submission {" +
                "createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", submissionId=" + submissionId +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", instruction='" + instruction + '\'' +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }
}
