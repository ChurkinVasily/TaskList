package ru.churkin.ui;

import ru.churkin.entity.User;

import java.io.IOException;
import java.sql.SQLException;

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
    public void execute() throws IOException, SQLException {
        User user = new User();
        System.out.println("введите ваше Имя пользователя (userName)");
        String userName = serviceLocator.getTerminalService().nextLine();
        if (serviceLocator.getUserService().isExist(userName)) {
            System.out.println("введите пароль");
            String userPassword = serviceLocator.getTerminalService().nextLine();
            user.setName(userName);
            user.setPassword(userPassword);
            if (serviceLocator.getUserService().validateUser(user)) {
                System.out.println("успешный вход под именем " + userName);
                serviceLocator.getUserService().getUserByName(userName);
            } else System.out.println("неверный пароль");
        } else {
            System.out.println("не существующее имя пользователя");
        }
    }
}
