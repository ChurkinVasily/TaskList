package ru.churkin.tm.api;

import ru.churkin.tm.repository.ConnectionDB;
import ru.churkin.tm.service.TerminalService;
import ru.churkin.tm.service.UserServiceImpl;

import java.util.Map;

public interface ServiceLocator {

//    TaskService getTaskService();
//
//    ProjectService getProjectService();

    TerminalService getTerminalService();

//    UserServiceImpl getUserService();

    Map<String, Command> getCommandMap();

}
