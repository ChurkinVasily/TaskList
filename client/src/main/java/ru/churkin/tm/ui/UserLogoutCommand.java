package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.Session;

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
        Session currentSession = serviceLocator.getCurrentSession();
        String sessionId = currentSession.getId();
        serviceLocator.getSessionEndpoint().deleteSessionById(sessionId);
        System.out.println("удалено из базы");
        serviceLocator.setCurrentSession(null);
//        serviceLocator.getUserEndpoint().setCurrentUser(null);
        System.out.println("вы вышли из профиля");
    }
}
