package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.Session;
import ru.churkin.tm.endpoint.UserDTO;

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
        UserDTO user = new UserDTO();
        System.out.println("введите ваше Имя пользователя (userName)");
        String userName = serviceLocator.getTerminalService().nextLine();
        if (serviceLocator.getUserEndpoint().isExist(userName)) {
            System.out.println("введите пароль");
            String userPassword = serviceLocator.getTerminalService().nextLine();
            user.setName(userName);
            user.setPassword(userPassword);
            if (serviceLocator.getUserEndpoint().validateUser(user.getName(), user.getPassword())) {
                System.out.println("успешный вход под именем " + userName);
//                serviceLocator.getUserEndpoint().getUserByName(userName);

                Session session = serviceLocator.getSessionEndpoint().createSession(user); // -- создали сессию в базе
                serviceLocator.setCurrentSession(session); // -- присвоили бутстрапу текущую сессию
                System.out.println("сессия активна:");
                System.out.println(serviceLocator.getCurrentSession().getId());
            } else System.out.println("неверный пароль");
        } else {
            System.out.println("не существующее имя пользователя");
        }
    }
}

    ///// ---- старый метод логина----------
//    @Override
//    public void execute() throws IOException, Exception_Exception {
//        UserDTO user = new UserDTO();
//        System.out.println("введите ваше Имя пользователя (userName)");
//        String userName = serviceLocator.getTerminalService().nextLine();
//        if (serviceLocator.getUserEndpoint().isExist(userName)) {
//            System.out.println("введите пароль");
//            String userPassword = serviceLocator.getTerminalService().nextLine();
//            user.setName(userName);
//            user.setPassword(userPassword);
//            if (serviceLocator.getUserEndpoint().validateUser(user.getName(), user.getPassword())) {
//                System.out.println("успешный вход под именем " + userName);
//                serviceLocator.getUserEndpoint().getUserByName(userName);
//            } else System.out.println("неверный пароль");
//        } else {
//            System.out.println("не существующее имя пользователя");
//        }
//    }