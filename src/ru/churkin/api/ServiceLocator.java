package ru.churkin.api;

import ru.churkin.service.TerminalService;

import java.util.Map;

public interface ServiceLocator {

    TaskService getTaskService();

    ProjectService getProjectService();

    TerminalService getTerminalService();

    Map<String, Command> getCommandMap();

}
