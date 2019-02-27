package ru.churkin.service;

import ru.churkin.api.ITaskRepository;
import ru.churkin.api.TaskService;
import ru.churkin.entity.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TaskServiceImpl implements TaskService {

    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public boolean createTask(Task task) throws SQLException {
        String taskName = task.getName();
        boolean isConsist = false;
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (taskName.equals(entry.getValue().getName())) {
                isConsist = true;
            }
        }
        if (isConsist || task.getName().equals("")) {
            return false;
        } else {
            taskRepository.createTask(task);
            return true;
        }
    }

    @Override
    public Task findTaskByName(String name) throws SQLException {
        boolean isConsist = false;
        for (Map.Entry<String, Task> map : taskRepository.getTaskMap().entrySet()) {
            Task nTask = map.getValue();
            if (name.equals(nTask.getName())) {
                isConsist = true;
            }
        }
        if (isConsist) {
            return taskRepository.findTaskByName(name);
        } else return null;
    }

    @Override
    public List<Task> findTaskByUserId(String userId) throws SQLException {
        boolean isConsist = false;
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (userId.equals(entry.getValue().getUserId())) {
                isConsist = true;
            }
        }
        if (isConsist) return taskRepository.findTasksByUserId(userId);
        else return null;
    }

    @Override
    public boolean updateTask(String name, Task task) throws SQLException {
        boolean isConsist = false;
        String id = "";
        for (Map.Entry<String, Task> map : taskRepository.getTaskMap().entrySet()) {
            if (name.equals(map.getValue().getName())) {
                id = map.getValue().getId();
                task.setId(id);
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            taskRepository.updateTask(task);
            return true;
        }
    }

    @Override
    public boolean deleteTask(String name) throws SQLException {
        boolean isConsist = false;
        String idForRemove = "";
        for (Map.Entry<String, Task> entry : taskRepository.getTaskMap().entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                idForRemove = entry.getValue().getId();
                isConsist = true;
            }
        }
        if (!isConsist || name.equals("")) {
            return false;
        } else {
            taskRepository.deleteTask(idForRemove);
            return true;
        }
    }

    @Override
    public Map<String, Task> getTasksAll() throws SQLException {
        if (!taskRepository.getTaskMap().isEmpty()) {
            return taskRepository.getTaskMap();
        } else return null;
    }
}
