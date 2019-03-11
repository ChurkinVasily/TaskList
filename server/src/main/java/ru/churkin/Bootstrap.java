package ru.churkin;

import ru.churkin.tm.api.ProjectService;
import ru.churkin.tm.api.ServiceLocator;
import ru.churkin.tm.api.TaskService;
import ru.churkin.tm.api.UserService;
import ru.churkin.tm.endpoint.ProjectEndpoint;
import ru.churkin.tm.endpoint.TaskEndpoint;
import ru.churkin.tm.endpoint.UserEndpoint;
import ru.churkin.tm.repository.ConnectionInitializer;
import ru.churkin.tm.service.TaskServiceJPA;
import ru.churkin.tm.service.UserServiceJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;

@ApplicationScoped
public class Bootstrap implements ServiceLocator {

    final ServiceLocator serviceLocator = this;

    @Inject
    ConnectionInitializer connDB;
//    final static ConnectionInitializer connDB = new ConnectionInitializer();

    @Inject
    private ProjectService projectServiceJPA;

    @Inject
    private TaskService taskServiceJPA;

    @Inject
    private UserService userServiceJPA;


   final EntityManagerFactory entityManagerFactory = connDB.getEntityManagerFactory();

//    final TaskService taskServiceJPA = new TaskServiceJPA(entityManagerFactory);
//    final ProjectService projectServiceJPA = new ProjectServiceJPA(entityManagerFactory);
//final UserService userServiceJPA = new UserServiceJPA(entityManagerFactory);


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
        return taskServiceJPA;
    }

    @Override
    public ProjectService getProjectService() {
        return projectServiceJPA;
    }

    @Override
    public UserService getUserService() {
        return userServiceJPA;
    }

    @Override
    public ConnectionInitializer connDB() {
        return connDB;
    }
}
