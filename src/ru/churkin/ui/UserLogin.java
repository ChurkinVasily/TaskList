package ru.churkin.ui;

import ru.churkin.entity.User;

import java.io.IOException;

public class UserLogin extends CommandAbstract {

    @Override
    public String name() {
        return "login";
    }

    @Override
    public String description() {
        return "login";
    }

    @Override
    public void execute() throws IOException {
        User user = new User();
        System.out.println("введите ваше Имя пользователя (userName)");
        String userName = serviceLocator.getTerminalService().nextLine();
        if (serviceLocator.getUserService().isExist(userName)) {
            System.out.println("введите пароль");
            String userPassword = serviceLocator.getTerminalService().nextLine();
            user.setName(userName);
            user.setPassword(userPassword);
            if (serviceLocator.getUserService().validateUser(user)) {
                System.out.println("успешный вход");
                /// - todo какое-то действие??????
                /// установить юзера currentUser
            }
            else System.out.println("неверный пароль");
        }
        else {
            System.out.println("не существующее имя пользователя");
        }


    }
}
