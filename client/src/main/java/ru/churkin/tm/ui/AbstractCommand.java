package ru.churkin.tm.ui;

import ru.churkin.tm.api.Command;
import ru.churkin.tm.api.ServiceLocator;
import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.Session;

import java.io.IOException;
import java.sql.SQLException;

public abstract class AbstractCommand implements Command {

    protected ServiceLocator serviceLocator;

    @Override
    public void setLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public abstract boolean isAuth();

    public abstract String name();

    public abstract String description();

    public abstract void execute() throws IOException, SQLException, Exception_Exception;

    public void validateSession(Session currentSession) throws Exception_Exception {
        if (!serviceLocator.getSessionEndpoint().validate(currentSession)) {
            System.out.println("сессия не валидирована");
            return;
        }
    }
}
