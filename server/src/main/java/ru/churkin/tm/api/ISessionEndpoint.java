package ru.churkin.tm.api;

import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;

public interface ISessionEndpoint {

    @WebMethod
    Session createSession (@WebParam(name = "userDTO") UserDTO userDTO) throws Exception;

}
