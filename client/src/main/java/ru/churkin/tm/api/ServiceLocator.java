package ru.churkin.tm.api;

import ru.churkin.tm.endpoint.ProjectEndpoint;
import ru.churkin.tm.endpoint.TaskEndpoint;
import ru.churkin.tm.endpoint.UserEndpoint;

import java.util.Map;

public interface ServiceLocator {

    TaskEndpoint getTaskEndpoint();

    ProjectEndpoint getProjectEndpoint();

    TerminalService getTerminalService();

    UserEndpoint getUserEndpoint();

    Map<String, Command> getCommandMap();

}
