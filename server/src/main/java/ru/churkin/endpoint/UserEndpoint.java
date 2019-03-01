package ru.churkin.endpoint;

import ru.churkin.api.IUserEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.User;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class UserEndpoint implements IUserEndpoint {

    private ServiceLocator serviceLocator;

    public UserEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createNewUser(@WebParam(name = "user") User user) throws Exception {
        return serviceLocator.getUserService().createNewUser(user);
    }

    @Override
    public User findUserById(@WebParam(name = "id") String id) throws Exception {
        return serviceLocator.getUserService().findUserById(id);
    }

    @Override
    public boolean isExist(@WebParam(name = "userName") String userName) throws Exception {
        return serviceLocator.getUserService().isExist(userName);
    }

    @Override
    public boolean validateUser(@WebParam(name = "user") User user) throws Exception {
        return serviceLocator.getUserService().validateUser(user);
    }

    @Override
    public User getCurrentUser() {
        return serviceLocator.getUserService().getCurrentUser();
    }

    @Override
    public void setCurrentUser(User user) throws Exception {
        serviceLocator.getUserService().setCurrentUser(user);
    }

    @Override
    public void getUserByName(@WebParam(name = "userName") String userName) throws Exception {
        serviceLocator.getUserService().getUserByName(userName);
    }
}
