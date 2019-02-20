package ru.churkin.api;

import ru.churkin.entity.User;

import java.io.IOException;

public interface Command {

    boolean isAuth();

    String name();

    String description();

    void execute() throws IOException;

    void execute(User user) throws IOException;

    void setLocator(ServiceLocator serviceLocator);

}
