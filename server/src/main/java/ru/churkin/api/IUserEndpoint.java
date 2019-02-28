package ru.churkin.api;

import ru.churkin.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IUserEndpoint {

    @WebMethod
    boolean createNewUser(@WebParam(name = "user") User user) throws Exception;

    @WebMethod
    User findUserById(@WebParam(name = "id") String id) throws Exception;

    @WebMethod
    boolean isExist(@WebParam(name = "userName") String userName) throws Exception;

    @WebMethod
    boolean validateUser(@WebParam(name = "user") User user) throws Exception;

    @WebMethod
    User getCurrentUser();

    @WebMethod
    void getUserByName(@WebParam(name = "userName") String userName) throws Exception;

    @WebMethod
    void setCurrentUser(@WebParam(name = "user") User user) throws Exception;


}
