package ru.churkin.repository;

import ru.churkin.entity.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskRepository {

    private Map<String, Task> taskMap = new HashMap<>();

    public TaskRepository() {
    }

    public void createTask(Task task) {
        String id = UUID.randomUUID().toString();
        task.setId(id);
        taskMap.put(id, task);
    }

    public Task findTaskByName(String name) {
        Task task = new Task();
        for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
            task = entry.getValue();
            if (name.equals(task.getName())) {
               return task; }
        }
        return task;
    }

    public void updateTask(String id, Task task) {
        taskMap.put(id,task);
    }

    public void deleteTask(String id) {
        taskMap.remove(id);
    }

    public Map<String, Task> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<String, Task> taskMap) {
        this.taskMap = taskMap;
    }
}