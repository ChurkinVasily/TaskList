package ru.churkin.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.churkin.tm.entity.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TaskDTO {

    private String id;
    @Nullable
    private String name;
    @Nullable
    private String description;
    @Nullable
    private String timeStart;
    @Nullable
    private String timeFinish;
    @Nullable
    private String projectId;
    @Nullable
    private String userId;

    public TaskDTO(@Nullable String name) {
        this.name = name;
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

    public TaskDTO(String id,
                   @Nullable String name,
                   @Nullable String description,
                   @Nullable String timeStart,
                   @Nullable String timeFinish,
                   @Nullable String projectId,
                   @Nullable String userId) {
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

    @Override
    public String toString() {
        return "Tassk{" +
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
