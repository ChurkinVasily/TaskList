package ru.churkin.ui;

import java.io.IOException;

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
    public void execute() throws IOException {
//        String userId = serviceLocator.getUserService().currentUser.getId();
        serviceLocator.getUserService().currentUser = null;
        System.out.println("вы вышли из профиля");
    }
}
