package ru.churkin.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.churkin.tm.api.IUserEndpoint;
import ru.churkin.tm.api.UserService;
import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.User;

import javax.jws.WebParam;
import javax.jws.WebService;

@Component
@WebService
public class UserEndpoint implements IUserEndpoint {

//    @Inject
    @Autowired
    private UserService userService;

    @Override
    public boolean createNewUser(@WebParam(name = "userName") String userName,
                                 @WebParam(name = "pass") String pass) throws Exception {
        return userService.createNewUser(userName, pass);
    }

    @Override
    public UserDTO findUserById(@WebParam(name = "id") String id) throws Exception {
        User user = userService.findUserById(id);
        return UserDTO.toDTO(user);
    }

    @Override
    public UserDTO findUserByName(String userName) throws Exception {
        User user = userService.findUserByName(userName);
        return UserDTO.toDTO(user);
    }

    @Override
    public boolean isExist(@WebParam(name = "userName") String userName) throws Exception {
        return userService.isExist(userName);
    }

    @Override
    public boolean validateUser(@WebParam(name = "userName") String userName,
                                @WebParam(name = "pass") String pass) throws Exception {
        return userService.validateUser(userName, pass);
    }

    @Override
    public UserDTO getCurrentUser() {
        User user = userService.getCurrentUser();
        return UserDTO.toDTO(user);
    }

    @Override
    public void setCurrentUser(@WebParam(name = "userDto") User user) throws Exception {
        userService.setCurrentUser(user);
    }

    @Override
    public void getUserByName(@WebParam(name = "userName") String userName) throws Exception {
        userService.getUserByName(userName);
    }
}
