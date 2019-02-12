package ru.churkin.api;

public interface Locator {

    TaskService getTaskService();

    ProjectService getProjectService();

}
