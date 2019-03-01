package ru.churkin.entity;

import org.apache.ibatis.type.Alias;

@Alias("task")
public class Task {

    private String id;
    private String name;
    private String description;
    private String timeStart;
    private String timeFinish;
    private String projectId;
    private String userId;

    public Task(String name) {
        this.name = name;
    }

    public Task() {
    }

    public Task(String id, String name, String description, String timeStart, String timeFinish, String projectId, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.projectId = projectId;
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeFinish(String timeFin) {
        this.timeFinish = timeFin;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeFinish='" + timeFinish + '\'' +
                ", projectId='" + projectId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
