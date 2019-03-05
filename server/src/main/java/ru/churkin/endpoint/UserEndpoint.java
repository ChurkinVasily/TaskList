package ru.churkin.endpoint;

import ru.churkin.api.IUserEndpoint;
import ru.churkin.api.ServiceLocator;
import ru.churkin.entity.User;
import ru.churkin.dto2.UserDTO;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class UserEndpoint implements IUserEndpoint {

    private ServiceLocator serviceLocator;

    public UserEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean createNewUser(@WebParam(name = "userName") String userName,
                                 @WebParam(name = "pass") String pass) throws Exception {
        return serviceLocator.getUserService().createNewUser(userName, pass);
    }

    @Override
    public UserDTO findUserById(@WebParam(name = "id") String id) throws Exception {
        User user = serviceLocator.getUserService().findUserById(id);
        return UserDTO.toDTO(user);
    }

    @Override
    public boolean isExist(@WebParam(name = "userName") String userName) throws Exception {
        return serviceLocator.getUserService().isExist(userName);
    }

    @Override
    public boolean validateUser(@WebParam(name = "userName") String userName,
                                @WebParam(name = "pass") String pass) throws Exception {
        return serviceLocator.getUserService().validateUser(userName, pass);
    }

    @Override
    public UserDTO getCurrentUser() {
        User user = serviceLocator.getUserService().getCurrentUser();
        return UserDTO.toDTO(user);
    }

    @Override
    public void setCurrentUser(@WebParam(name = "userDto") User user) throws Exception {
        serviceLocator.getUserService().setCurrentUser(user);
    }

    @Override
    public void getUserByName(@WebParam(name = "userName") String userName) throws Exception {
        serviceLocator.getUserService().getUserByName(userName);
    }
}
