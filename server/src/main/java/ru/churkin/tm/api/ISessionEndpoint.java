package ru.churkin.tm.api;

import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ISessionEndpoint {

    @WebMethod
    Session createSession (@WebParam(name = "userDTO") UserDTO userDTO) throws Exception;

    @WebMethod
    Session getSessionById(@WebParam(name = "sessionId") String sessionId) throws Exception;

    @WebMethod
    boolean validate(@WebParam(name = "session") Session session) throws Exception;

    @WebMethod
    void deleteSession(@WebParam(name = "Session") Session session) throws Exception;

}
