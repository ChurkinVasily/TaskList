package ru.churkin;

import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.ProjectService;
import ru.churkin.api.ServiceLocator;
import ru.churkin.api.TaskService;
import ru.churkin.api.UserService;
import ru.churkin.endpoint.ProjectEndpoint;
import ru.churkin.endpoint.TaskEndpoint;
import ru.churkin.endpoint.UserEndpoint;
import ru.churkin.repository.ConnectionDB;
import ru.churkin.service.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Endpoint;

public class Bootstrap implements ServiceLocator {

    final ServiceLocator serviceLocator = this;

    final ConnectionDB connDB = new ConnectionDB();
    final EntityManagerFactory entityManagerFactory = connDB.getEntityManagerFactory();
//    final SqlSessionFactory sqlSessionFactory = connDB.getSqlSessionFactory();
//    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(sqlSessionFactory);
//    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(sqlSessionFactory);
//    final UserServiceImpl userServiceImpl = new UserServiceImpl(sqlSessionFactory);

    TaskService taskServiceHib = new TaskServiceHib(entityManagerFactory);
    ProjectService projectServiceHib = new ProjectServiceHib(entityManagerFactory);
    UserService userServiceHib = new UserServiceHib(entityManagerFactory);

    final UserEndpoint userEndpoint = new UserEndpoint(serviceLocator);
    final TaskEndpoint taskEndpoint = new TaskEndpoint(serviceLocator);
    final ProjectEndpoint projectEndpoint = new ProjectEndpoint(serviceLocator);

    public Bootstrap() {
    }

    public void init() {

        Endpoint.publish("http://localhost:8080/TaskList/task?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/project?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/user?wsdl", userEndpoint);

    }

    @Override
    public TaskService getTaskService() {
        return taskServiceHib;
    }

    @Override
    public ProjectService getProjectService() {
        return projectServiceHib;
    }

    @Override
    public UserService getUserService() {
        return userServiceHib;
    }

    @Override
    public ConnectionDB connDB() {
        return connDB;
    }
}
