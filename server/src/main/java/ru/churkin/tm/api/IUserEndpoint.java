package ru.churkin.tm.api;

import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IUserEndpoint {

    @WebMethod
    boolean createNewUser(@WebParam(name = "userName") String userName,
                          @WebParam(name = "pass") String pass) throws Exception;

    @WebMethod
    UserDTO findUserById(@WebParam(name = "id") String id) throws Exception;

    @WebMethod
    boolean isExist(@WebParam(name = "userName") String userName) throws Exception;

    @WebMethod
    boolean validateUser(@WebParam(name = "userName") String userName,
                         @WebParam(name = "pass") String pass) throws Exception;

    @WebMethod
    UserDTO getCurrentUser();

    @WebMethod
    void getUserByName(@WebParam(name = "userName") String userName) throws Exception;

    @WebMethod
    void setCurrentUser(@WebParam(name = "user") User user) throws Exception;

}
