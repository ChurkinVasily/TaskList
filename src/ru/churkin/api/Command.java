package ru.churkin.api;

import ru.churkin.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public interface Command {

    boolean isAuth();

    String name();

    String description();

    void execute() throws IOException, SQLException;

    void setLocator(ServiceLocator serviceLocator);

}
