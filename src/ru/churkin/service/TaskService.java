package ru.churkin.service;


import ru.churkin.repository.TaskRepository;
import ru.churkin.ui.Command;

import java.io.IOException;
import java.util.Map;

public class TaskService {

    private String id;
    private String name;
    private String description;
    private String timeStart;
    private String timeFinish;
    private String projectId;

    private TaskRepository taskRepository;
    private Map<String, Command> commandList;

    public TaskService(TaskRepository taskRepository, Map<String, Command> commandList) {
        this.taskRepository = taskRepository;
        this.commandList = commandList;
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public void execute(String commandName) throws IOException {
        Command command = commandList.get(commandName);
        if (command == null) {
            System.out.println("no such command");
        }
        command.execute();
    }

    public TaskService(String name) {
        this.name = name;
    }

    public TaskService(){
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

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}


