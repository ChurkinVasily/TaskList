package ru.churkin.api;

import ru.churkin.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;

@WebService
public interface IUserEndpoint {

    @WebMethod
    boolean createNewUser(@WebParam(name = "user") User user) throws SQLException;

    @WebMethod
    User findUserById(@WebParam(name = "id") String id) throws SQLException;

    @WebMethod
    boolean isExist(@WebParam(name = "userName") String userName) throws SQLException;

    @WebMethod
    boolean validateUser(@WebParam(name = "user") User user) throws SQLException;

    @WebMethod
    User getCurrentUser();

    @WebMethod
    void getUserByName(@WebParam(name = "userName") String userName) throws SQLException;


}
