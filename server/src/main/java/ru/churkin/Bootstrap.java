package ru.churkin;

import ru.churkin.api.ProjectService;
import ru.churkin.api.ServiceLocator;
import ru.churkin.api.TaskService;
import ru.churkin.api.UserService;
import ru.churkin.endpoint.ProjectEndpoint;
import ru.churkin.endpoint.TaskEndpoint;
import ru.churkin.endpoint.UserEndpoint;
import ru.churkin.repository.ConnectionDB;
import ru.churkin.service.ProjectServiceJPA;
import ru.churkin.service.TaskServiceJPA;
import ru.churkin.service.UserServiceJPA;

import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;

public class Bootstrap implements ServiceLocator {

    final ServiceLocator serviceLocator = this;

    final static ConnectionDB connDB = new ConnectionDB();
    final static EntityManagerFactory entityManagerFactory = connDB.getEntityManagerFactory();

    final TaskService taskServiceHib = new TaskServiceJPA(entityManagerFactory);
    final ProjectService projectServiceHib = new ProjectServiceJPA(entityManagerFactory);
    final UserService userServiceHib = new UserServiceJPA(entityManagerFactory);

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
