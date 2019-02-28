package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.User;

import java.io.IOException;

public class UserLoginCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return false;
    }

    @Override
    public String name() {
        return "login";
    }

    @Override
    public String description() {
        return "login";
    }

    @Override
    public void execute() throws IOException, Exception_Exception {
        User user = new User();
        System.out.println("введите ваше Имя пользователя (userName)");
        String userName = serviceLocator.getTerminalService().nextLine();
        if (serviceLocator.getUserEndpoint().isExist(userName)) {
            System.out.println("введите пароль");
            String userPassword = serviceLocator.getTerminalService().nextLine();
            user.setName(userName);
            user.setPassword(userPassword);
            if (serviceLocator.getUserEndpoint().validateUser(user)) {
                System.out.println("успешный вход под именем " + userName);
                serviceLocator.getUserEndpoint().getUserByName(userName);
            } else System.out.println("неверный пароль");
        } else {
            System.out.println("не существующее имя пользователя");
        }
    }
}
