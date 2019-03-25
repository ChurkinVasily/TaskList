package ru.churkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.churkin.tm.api.ISessionService;
import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;
import ru.churkin.tm.repository.SessionRepository;

import java.util.logging.Logger;

@Transactional
@NoArgsConstructor
@Service
public class SessionServiceJPA implements ISessionService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session createSession(@Nullable final UserDTO user) {
        logger.info(" --------------create session start");
        if (user == null) return null;
        /// создание сессии по юзеру
        Session session = new Session(user.getId());
        session.setSignature(createSignature(user));
        sessionRepository.save(session);
        logger.info(" --------------create session finish " + session);
        return session;
    }

    @Nullable
    @Override
    public Session getSessionById(@Nullable final String id) {
        logger.info("--------------get session by id start");
        if (id == null || id.isEmpty()) {
            return null;
        }
        Session session = sessionRepository.getSessionById(id);
        logger.info("--------------get session by id finish " + session);
        return session;
    }

    @Nullable
    @Override
    public Session getSessionByUserId(@Nullable final String userId) {
        logger.info("------------------get session by user id start ");
        if (userId == null || userId.isEmpty()) return null;
        Session session = sessionRepository.getByUserId(userId);
        logger.info("------------------get session by user id finish " + session);
        return session;
    }

    @Override
    public void deleteSession(@Nullable final Session session) {
        logger.info(" ----------------- delete session start");
        if (session == null) return;
        sessionRepository.delete(session);
        logger.info(" ----------------- delete session finish");
    }

    @Override
    public void deleteSessionById(@Nullable final String id) {
        logger.info("-------------------delete session by id start");
        if (id == null || id.isEmpty()) return;
        Session sessionInstance = sessionRepository.save(getSessionById(id));
        sessionRepository.delete(sessionInstance);
        logger.info("delete session by id finish");
    }

    @Override
    public boolean validateSession(@Nullable final Session session) {
        logger.info(" ----------------- validate session start");
        if (session == null) return false;
        String id = session.getId();
        Session sessionInBase = getSessionById(id);
        if (!session.getSignature().equals(sessionInBase.getSignature())) {
            return false;
        }
        logger.info(" ----------------- validate session finish ");
        return true;
    }

    private String createSignature(@Nullable final UserDTO user) {
        final String salt = "qsqs";
        final int count = 5;
        long time = System.currentTimeMillis();
        String signature = (user.getName() + user.getPassword() + time).hashCode() + "";
        for (int i=0; i<count; i++) {
            signature = (signature  + salt).hashCode() + "";
        }
        return signature;
    }


}
