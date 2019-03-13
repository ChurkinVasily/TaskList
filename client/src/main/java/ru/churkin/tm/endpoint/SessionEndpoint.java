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
 * 2019-03-13T18:58:59.240+03:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://endpoint.tm.churkin.ru/", name = "SessionEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface SessionEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/SessionEndpoint/createSessionRequest", output = "http://endpoint.tm.churkin.ru/SessionEndpoint/createSessionResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/SessionEndpoint/createSession/Fault/Exception")})
    @RequestWrapper(localName = "createSession", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateSession")
    @ResponseWrapper(localName = "createSessionResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.CreateSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.Session createSession(
        @WebParam(name = "userDTO", targetNamespace = "")
        ru.churkin.tm.endpoint.UserDTO userDTO
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/SessionEndpoint/getSessionByIdRequest", output = "http://endpoint.tm.churkin.ru/SessionEndpoint/getSessionByIdResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/SessionEndpoint/getSessionById/Fault/Exception")})
    @RequestWrapper(localName = "getSessionById", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetSessionById")
    @ResponseWrapper(localName = "getSessionByIdResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.GetSessionByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.churkin.tm.endpoint.Session getSessionById(
        @WebParam(name = "sessionId", targetNamespace = "")
        java.lang.String sessionId
    ) throws Exception_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.churkin.ru/SessionEndpoint/validateRequest", output = "http://endpoint.tm.churkin.ru/SessionEndpoint/validateResponse", fault = {@FaultAction(className = Exception_Exception.class, value = "http://endpoint.tm.churkin.ru/SessionEndpoint/validate/Fault/Exception")})
    @RequestWrapper(localName = "validate", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.Validate")
    @ResponseWrapper(localName = "validateResponse", targetNamespace = "http://endpoint.tm.churkin.ru/", className = "ru.churkin.tm.endpoint.ValidateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean validate(
        @WebParam(name = "session", targetNamespace = "")
        ru.churkin.tm.endpoint.Session session
    ) throws Exception_Exception;
}
