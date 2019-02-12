package ru.churkin.service;

import ru.churkin.api.Locator;
import ru.churkin.api.ProjectService;
import ru.churkin.api.TaskService;

public class ServiceLocator implements Locator {



    @Override
    public TaskServiceImpl getTaskService() {
        return null;
    }

    @Override
    public ProjectServiceImpl getProjectService() {
       return null;
    }
}
