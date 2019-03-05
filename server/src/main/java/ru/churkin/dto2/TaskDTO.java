package ru.churkin.dto2;

import ru.churkin.entity.Project;
import ru.churkin.entity.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TaskDTO {

    private String id;
    private String name;
    private String description;
    private String timeStart;
    private String timeFinish;
    private String projectId;
    private String userId;

    public TaskDTO(String name) {
        this.name = name;
    }

    public TaskDTO() {
    }

    public TaskDTO(final Task task) {
        if (task == null) return;
        id = task.getId();
        name = task.getName();
        description = task.getDescription();
        timeStart = task.getTimeStart();
        timeFinish = task.getTimeFinish();
        projectId = task.getProject().getId();
        userId = task.getUser().getId();
    }

    public TaskDTO(String id, String name, String description, String timeStart, String timeFinish, String projectId, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.projectId = projectId;
        this.userId = userId;
    }

    public static TaskDTO toDTO(Task task) {
        if (task == null) return null;
        return new TaskDTO(task);
    }

    public static List<TaskDTO> toDTO(Collection<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) return Collections.emptyList();
        List<TaskDTO> list = new ArrayList<>();
        for (Task task : tasks) {
            list.add(new TaskDTO(task));
        }
        return list;
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
