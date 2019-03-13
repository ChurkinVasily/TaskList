package ru.churkin.tm.api;

import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;
import ru.churkin.tm.entity.User;

public interface ISessionService {

    Session createSession(UserDTO user);

    void deleteSession(Session session);

    void validateSession(Session session);

//    Session getSessionById(String id);

    Session getSessionByUserId(String userId);



}
