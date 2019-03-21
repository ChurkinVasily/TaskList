package ru.churkin.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.Nullable;
import ru.churkin.tm.api.ISessionService;
import ru.churkin.tm.dto.UserDTO;
import ru.churkin.tm.entity.Session;
import ru.churkin.tm.repository.SessionRepositoryDS;

import javax.inject.Inject;
import java.util.logging.Logger;

@Transactional
public class SessionServiceJPA implements ISessionService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private SessionRepositoryDS sessionRepository;

    @Override
//    @Transactional
    public Session createSession(@Nullable final UserDTO user) {
        logger.info(" --------------create session start");
        if (user == null) return null;
        /// создание сессии по юзеру
        Session session = new Session(user.getId());
//        int sign = (user.getName() + user.getPassword()).hashCode(); ----------------
//        session.setSignature(Integer.toString(sign));    ----------------------------
        session.setSignature(createSignature(user));
        sessionRepository.persist(session);
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
        sessionRepository.remove(session);
        logger.info(" ----------------- delete session finish");
    }

    @Override
    public void deleteSessionById(@Nullable final String id) {
        logger.info("-------------------delete session by id start");
        if (id == null || id.isEmpty()) return;
        Session sessionInstance = sessionRepository.merge(getSessionById(id));
        sessionRepository.remove(sessionInstance);
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
        final String sault = "qsqs";
        final int count = 5;
        long time = System.currentTimeMillis();
        String signature = (user.getName() + user.getPassword() + time).hashCode() + "";
        for (int i=0; i<count; i++) {
            signature = (signature  + sault).hashCode() + "";
            System.out.println(signature);
        }
        return signature;
    }


}
