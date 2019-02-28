package ru.churkin;

import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.ProjectService;
import ru.churkin.api.ServiceLocator;
import ru.churkin.api.TaskService;
import ru.churkin.endpoint.ProjectEndpoint;
import ru.churkin.endpoint.TaskEndpoint;
import ru.churkin.endpoint.UserEndpoint;
import ru.churkin.repository.ConnectionDB;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.service.UserServiceImpl;

import javax.xml.ws.Endpoint;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class Bootstrap implements ServiceLocator {

//    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final ServiceLocator serviceLocator = this;

    final ConnectionDB connMyBatis = new ConnectionDB();
    final SqlSessionFactory sqlSessionFactory = connMyBatis.getSqlSessionFactory();
    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(sqlSessionFactory);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(sqlSessionFactory);
    final UserServiceImpl userServiceImpl = new UserServiceImpl(sqlSessionFactory);

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
        return taskServiceImpl;
    }

    @Override
    public ProjectService getProjectService() {
        return projectServiceImpl;
    }

    @Override
    public UserServiceImpl getUserService() {
        return userServiceImpl;
    }
}
