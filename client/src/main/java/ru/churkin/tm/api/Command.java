package ru.churkin.tm.api;

import ru.churkin.tm.endpoint.Exception_Exception;

import java.io.IOException;
import java.sql.SQLException;

public interface Command {

    boolean isAuth();

    String name();

    String description();

    void execute() throws IOException, SQLException, Exception_Exception;

    void setLocator(ServiceLocator serviceLocator);

}
