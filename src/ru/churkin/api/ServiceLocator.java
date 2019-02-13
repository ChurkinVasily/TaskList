package ru.churkin.api;

import ru.churkin.service.TerminalService;

public interface ServiceLocator {

    TaskService getTaskService();

    ProjectService getProjectService();

    TerminalService getTerminalService();

}
