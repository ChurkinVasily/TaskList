package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.User;

import java.io.IOException;

public abstract class AbstractCommand implements Command {

    protected ServiceLocator serviceLocator;

    @Override
    public void setLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public abstract boolean isAuth();

    public abstract String name();

    public abstract String description();

    public void execute(User user) throws IOException {
        if (!isAuth() || (isAuth() && serviceLocator.getUserService().validateUser(user)))
        {
            this.execute();
        }
        else System.out.println("требуется авторизация");
    }

    public abstract void execute() throws IOException;
}
