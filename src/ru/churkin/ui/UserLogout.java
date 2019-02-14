package ru.churkin.ui;

import java.io.IOException;

public class UserLogout extends CommandAbstract {

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


        System.out.println("вы вышли из профиля");
    }
}
