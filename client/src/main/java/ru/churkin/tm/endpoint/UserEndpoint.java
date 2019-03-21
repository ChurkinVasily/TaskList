package ru.churkin.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2019-03-21T13:42:12.995+03:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://endpoint.tm.churkin.ru/", name = "UserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface UserEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/setCurrentUserRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/setCurrentUserResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/UserEndpoint/setCurrentUser/Fault/Exception")})
    @RequestWrapper(localName = "setCurrentUser", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.SetCurrentUser")
    @ResponseWrapper(localName = "setCurrentUserResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.SetCurrentUserResponse")
    public void setCurrentUser(
        @WebParam(name = "userDto", targetNamespace = "")
        ru.churkin.tm.endpoint.User userDto
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/validateUserRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/validateUserResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/UserEndpoint/validateUser/Fault/Exception")})
    @RequestWrapper(localName = "validateUser", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.ValidateUser")
    @ResponseWrapper(localName = "validateUserResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.ValidateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean validateUser(
        @WebParam(name = "userName", targetNamespace = "")
        java.lang.String userName,
        @WebParam(name = "pass", targetNamespace = "")
        java.lang.String pass
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/getCurrentUserRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/getCurrentUserResponse")
    @RequestWrapper(localName = "getCurrentUser", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetCurrentUser")
    @ResponseWrapper(localName = "getCurrentUserResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetCurrentUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.UserDTO getCurrentUser();

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/findUserByNameRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/findUserByNameResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/UserEndpoint/findUserByName/Fault/Exception")})
    @RequestWrapper(localName = "findUserByName", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindUserByName")
    @ResponseWrapper(localName = "findUserByNameResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindUserByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.UserDTO findUserByName(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/findUserByIdRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/findUserByIdResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/UserEndpoint/findUserById/Fault/Exception")})
    @RequestWrapper(localName = "findUserById", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindUserById")
    @ResponseWrapper(localName = "findUserByIdResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.FindUserByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.UserDTO findUserById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/getUserByNameRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/getUserByNameResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/UserEndpoint/getUserByName/Fault/Exception")})
    @RequestWrapper(localName = "getUserByName", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetUserByName")
    @ResponseWrapper(localName = "getUserByNameResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetUserByNameResponse")
    public void getUserByName(
        @WebParam(name = "userName", targetNamespace = "")
        java.lang.String userName
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/isExistRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/isExistResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/UserEndpoint/isExist/Fault/Exception")})
    @RequestWrapper(localName = "isExist", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.IsExist")
    @ResponseWrapper(localName = "isExistResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.IsExistResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean isExist(
        @WebParam(name = "userName", targetNamespace = "")
        java.lang.String userName
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/UserEndpoint/createNewUserRequest", output = "http://endpoint.tm.churkin.ru/UserEndpoint/createNewUserResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/UserEndpoint/createNewUser/Fault/Exception")})
    @RequestWrapper(localName = "createNewUser", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateNewUser")
    @ResponseWrapper(localName = "createNewUserResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateNewUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean createNewUser(
        @WebParam(name = "userName", targetNamespace = "")
        java.lang.String userName,
        @WebParam(name = "pass", targetNamespace = "")
        java.lang.String pass
    ) throws Exception_Exception;
}
