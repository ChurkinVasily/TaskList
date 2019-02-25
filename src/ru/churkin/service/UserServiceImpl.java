package ru.churkin.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.IUserRepository;
import ru.churkin.repository.ProjectMapper;
import ru.churkin.repository.UserMapper;
import ru.churkin.entity.User;

import java.sql.SQLException;
import java.util.Map;

public class UserServiceImpl {

    public User currentUser = null;

    private SqlSessionFactory sqlSessionFactory;

    public UserServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

//    SqlSession sqlSession = sqlSessionFactory.openSession();
//    UserMapper userRepository = sqlSession.getMapper(UserMapper.class);

    public boolean createNewUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        String userName = user.getName();
        String userPassword = user.getPassword();
        boolean isConsist = false;
        if (userName.equals("") || userPassword.equals("")) {
            return false;
        } else {
            for (Map.Entry<String, User> entry : mapper.getUserMap().entrySet()) {
                if (!isConsist && userName.equals(entry.getValue().getName())) {
                    isConsist = true;
                }
            }
        }
        if (isConsist) {
            return false;
        } else {
            mapper.createUser(user);
            session.commit();
            session.close();
            return true;
        }
    }

    public User findUserById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            return (mapper.findUserById(id));
        }
        finally {
            session.close();
        }
    }

    public boolean isExist(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            boolean isTrue = false;
            for (Map.Entry<String, User> entry : mapper.getUserMap().entrySet()) {
                if (userName.equals(entry.getValue().getName())) {
                    isTrue = true;
                }
            }
            return isTrue;
        }
        finally {
            session.close();
        }
    }

    public boolean validateUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            if (user != null) {
                String userName = user.getName();
                String userPassword = user.getPassword();
                boolean isValidate = false;
                for (Map.Entry<String, User> entry : mapper.getUserMap().entrySet()) {
                    if (userName != null && userName.equals(entry.getValue().getName())
                            && userPassword.equals(entry.getValue().getPassword())) {
                        isValidate = true;
                    }
                }
                return isValidate;
            } else return false;
        }
        finally {
            session.close();
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void getUserByName(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            if (isExist(userName)) {
                currentUser = mapper.findUserByName(userName);
            }
        }
        finally {
            session.close();
        }
    }

}
