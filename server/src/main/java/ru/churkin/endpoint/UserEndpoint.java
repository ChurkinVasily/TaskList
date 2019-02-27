package ru.churkin.endpoint;

import ru.churkin.api.IUserEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.User;

import javax.jws.WebService;
import java.sql.SQLException;

@WebService
public class UserEndpoint implements IUserEndpoint {

    private ServiceLocator serviceLocator;

    public UserEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createNewUser(User user) throws SQLException {
        return serviceLocator.getUserService().createNewUser(user);
    }

    @Override
    public User findUserById(String id) throws SQLException {
        return serviceLocator.getUserService().findUserById(id);
    }

    @Override
    public boolean isExist(String userName) throws SQLException {
        return serviceLocator.getUserService().isExist(userName);
    }

    @Override
    public boolean validateUser(User user) throws SQLException {
        return serviceLocator.getUserService().validateUser(user);
    }

    @Override
    public User getCurrentUser() {
        return serviceLocator.getUserService().getCurrentUser();
    }

    @Override
    public void getUserByName(String userName) throws SQLException {
        serviceLocator.getUserService().getUserByName(userName);
    }
}