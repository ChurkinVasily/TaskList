package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.api.ServiceLocator;
import ru.churkin.endpoint.Exception_Exception;

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
