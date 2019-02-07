package ru.churkin.repository;

import ru.churkin.entity.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskRepository {

    private Map<String, Task> taskMap = new HashMap<>();

    public void createTask() {
        Task result = new Task();
        String id = UUID.randomUUID().toString();
        result.setId(id);
        result.setName();
        result.setDescription();
        result.setTimeStart();
        result.setTimeFinish();
        result.setProjectId();
        taskMap.put(id,result);
    }

    public Task findTaskByName(String name) {
        Task task2;
        for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
            task2 = entry.getValue();
            if (name.equals(task2.getName())) {
               return task2; }
        }
    }

    public void updateTask(String id) {
        Task task = taskMap.get(id);
        task.setName();
        task.setDescription();
        task.setTimeStart();
        task.setTimeFinish();
        taskMap.put(id,task);
    }

    public void deleteTask(String id) {
        taskMap.remove(id);
    }





}
