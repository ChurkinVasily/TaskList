package ru.churkin.tm.endpoint;

import ru.churkin.tm.api.ISessionEndpoint;
import ru.churkin.tm.api.ISessionService;
import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;
import ru.churkin.tm.entity.User;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SessionEndpoint implements ISessionEndpoint {

    @Inject
    private ISessionService sessionService;

    @Override
    public Session createSession(@WebParam(name = "userDTO") UserDTO user) throws Exception {
        return sessionService.createSession(user);
    }

    @Override
    public Session getSessionById(@WebParam(name = "sessionId") String sessionId) throws Exception {
        return sessionService.getSessionById(sessionId);
    }

    @Override
    public boolean validate(@WebParam(name = "session") Session session) throws Exception {
        return sessionService.validateSession(session);
    }
}
