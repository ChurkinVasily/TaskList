package ru.churkin.repository;

import ru.churkin.entity.Task;

import java.util.*;

public class TaskRepository {

    private Map<String, Task> taskMap = new HashMap<>();

    {
        taskMap.put("t1", new Task("t1", "task1", "task 1", "t111", "t1111", "p1", "u1"));
        taskMap.put("t2", new Task("t2", "task2", "task 2", "t222", "t2222", "p1", "u2"));
        taskMap.put("t3", new Task("t3", "task3", "task 3", "t333", "t3333", "p2", "u1"));
    }

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
