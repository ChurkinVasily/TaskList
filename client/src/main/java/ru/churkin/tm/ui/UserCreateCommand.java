package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.UserDTO;

import java.io.IOException;

public class UserCreateCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return false;
    }

    @Override
    public String name() {
        return "reg";
    }

    @Override
    public String description() {
        return "REGistry new user";
    }

    @Override
    public void execute() throws IOException, Exception_Exception {
        UserDTO newUser = new UserDTO();
        System.out.println("Введите имя нового пользователя");
        newUser.setName(serviceLocator.getTerminalService().nextLine());
        System.out.println("Установите пароль нового пользователя");
        newUser.setPassword(serviceLocator.getTerminalService().nextLine());
        boolean isCreate = serviceLocator.getUserEndpoint().createNewUser(newUser.getName(), newUser.getPassword());
        if (isCreate) {
            System.out.println("новый пользователь успешно создан");
        } else {
            System.out.println("введено пустое или существующее имя пользователя или пустой пароль");
        }
    }
}
