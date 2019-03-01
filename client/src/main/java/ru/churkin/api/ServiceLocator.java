package ru.churkin.api;

import ru.churkin.endpoint.*;

import java.util.Map;

public interface ServiceLocator {

    TaskEndpoint getTaskEndpoint();

    ProjectEndpoint getProjectEndpoint();

    TerminalService getTerminalService();

    UserEndpoint getUserEndpoint();

    Map<String, Command> getCommandMap();

}
