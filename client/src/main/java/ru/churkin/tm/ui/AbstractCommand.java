package ru.churkin.tm.ui;

import ru.churkin.tm.api.Command;
import ru.churkin.tm.api.ServiceLocator;
import ru.churkin.tm.endpoint.Exception_Exception;

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
}
