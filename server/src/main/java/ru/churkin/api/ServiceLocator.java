package ru.churkin.api;

//import ru.churkin.service.TerminalService;
import ru.churkin.repository.ConnectionDB;
import ru.churkin.service.UserServiceImpl;

public interface ServiceLocator {

    TaskService getTaskService();

    ProjectService getProjectService();

//    TerminalService getTerminalService();

    UserService getUserService();

//    Map<String, Command> getCommandMap();

    ConnectionDB connDB();

}
