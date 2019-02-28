package ru.churkin.api;

import java.util.Map;

public interface ServiceLocator {

    //    TaskService getTaskService();
//
//    ProjectService getProjectService();
//
//    TerminalService getTerminalService();
//
//    UserServiceImpl getUserService();

    Map<String, Command> getCommandMap();

//    ConnectionDB connDB();

}
