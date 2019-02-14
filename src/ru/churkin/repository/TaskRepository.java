package ru.churkin.repository;

import ru.churkin.entity.Task;

import java.util.*;

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
            if (name.equals(entry.getValue().getName())) {
                task = entry.getValue();
            }
        }
        return task;
    }

    public List<Task> findTasksByUserId(String userId) {
        List<Task> list = new ArrayList<>();
        for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
            if (userId.equals(entry.getValue().getUserId())) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    public void updateTask(String id, Task task) {
        taskMap.put(id, task);
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
