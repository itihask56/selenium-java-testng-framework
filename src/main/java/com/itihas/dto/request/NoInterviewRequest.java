package com.itihas.dto.request;

public class NoInterviewRequest {

    private String task_type;
    private String taskUuid;
    private NoInterviewData data;

    public NoInterviewRequest(String task_type,
                              String taskUuid,
                              NoInterviewData data) {
        this.task_type = task_type;
        this.taskUuid = taskUuid;
        this.data = data;
    }

    public String getTask_type() {
        return task_type;
    }

    public String getTaskUuid() {
        return taskUuid;
    }

    public NoInterviewData getData() {
        return data;
    }
}