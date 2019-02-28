package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;

public class UserLogoutCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "logout";
    }

    @Override
    public String description() {
        return "logout";
    }

    @Override
    public void execute() throws Exception_Exception {
        serviceLocator.getUserEndpoint().setCurrentUser(null);
        System.out.println("вы вышли из профиля");
    }
}
