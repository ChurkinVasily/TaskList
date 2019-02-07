package ru.chirkin.repository;

import ru.chirkin.entity.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskRepository {

    Map<String, Task> taskMap = new HashMap<>();

    public void createTask() {
        Task task = new Task();
        String id = UUID.randomUUID().toString();
        task.setName();
        task.setDescription();
        task.setTimeStart();
        task.setTimeFin();
        taskMap.put(id,task);
    }

    public Task findTaskByName(String name) {
        for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                return entry.getValue();
            }
            else return null;
        }
    }

    public void updateTask(String id) {
        Task task = taskMap.get(id);
        task.setName();
        task.setDescription();
        task.setTimeStart();
        task.setTimeFin();
        taskMap.put(id,task);
    }

    public void deleteTask(String id) {
        taskMap.remove(id);
    }





}
