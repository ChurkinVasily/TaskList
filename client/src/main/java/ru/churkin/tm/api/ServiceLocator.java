package ru.churkin.tm.api;

import ru.churkin.tm.endpoint.*;

import java.util.Map;

public interface ServiceLocator {

    TaskEndpoint getTaskEndpoint();

    ProjectEndpoint getProjectEndpoint();

    TerminalService getTerminalService();

    UserEndpoint getUserEndpoint();

    SessionEndpoint getSessionEndpoint();

    Map<String, Command> getCommandMap();

    public Session getCurrentSession();

    public void setCurrentSession(Session session);

}
