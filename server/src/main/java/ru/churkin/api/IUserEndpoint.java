package ru.churkin.api;

import ru.churkin.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;

@WebService
public interface IUserEndpoint {

    @WebMethod
    boolean createNewUser(@WebParam User user) throws SQLException;

    @WebMethod
    User findUserById(@WebParam String id) throws SQLException;

    @WebMethod
    boolean isExist(@WebParam String userName) throws SQLException;

    @WebMethod
    boolean validateUser(@WebParam User user) throws SQLException;

    @WebMethod
    User getCurrentUser();

    @WebMethod
    void getUserByName(@WebParam String userName) throws SQLException;


}
