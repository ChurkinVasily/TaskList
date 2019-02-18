package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.api.ServiceLocator;

import java.io.IOException;

public abstract class AbstractCommand implements Command {

    protected ServiceLocator serviceLocator;

    @Override
    public void setLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public abstract String name();

    public abstract String description();

    public abstract void execute() throws IOException;
}
