package com.itihas.dto;

public class NoInterviewTaskData {
    private final String elderName;
    private final String subprocessRecordId;
    private final String taskUuid;

    public NoInterviewTaskData(String elderName, String subprocessRecordId, String taskUuid){
        this.elderName = elderName;
        this.subprocessRecordId = subprocessRecordId;
        this.taskUuid = taskUuid;
    }

    public String getElderName() {
        return elderName;
    }

    public String getSubprocessRecordId() {
        return subprocessRecordId;
    }

    public String getTaskUuid() {
        return taskUuid;
    }
}
