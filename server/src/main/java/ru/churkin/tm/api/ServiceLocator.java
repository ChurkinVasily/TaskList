package ru.churkin.tm.api;

//import ru.churkin.tm.service.TerminalService;
import ru.churkin.tm.repository.ConnectionInitializer;

public interface ServiceLocator {

    TaskService getTaskService();

    ProjectService getProjectService();

//    TerminalService getTerminalService();

    UserService getUserService();

//    Map<String, Command> getCommandMap();

//    ConnectionInitializer connDB();

}
