package ru.churkin.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.churkin.tm.api.ISessionEndpoint;
import ru.churkin.tm.api.ISessionService;
import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;

import javax.jws.WebParam;
import javax.jws.WebService;

@Component
@WebService
public class SessionEndpoint implements ISessionEndpoint {

//    @Inject
    @Autowired
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

    @Override
    public void deleteSession(@WebParam(name = "session") Session session) throws Exception {
        sessionService.deleteSession(session);
    }

    @Override
    public void deleteSessionById(@WebParam(name = "id") String id) throws Exception {
        sessionService.deleteSessionById(id);
    }
}
