package ru.churkin.api;

import java.io.IOException;

public interface Command {

    String name();

    String description();

    void execute() throws IOException;

    void setLocator(ServiceLocator serviceLocator);

}
