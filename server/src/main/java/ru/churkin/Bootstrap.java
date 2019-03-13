package ru.churkin;

import ru.churkin.tm.api.*;
import ru.churkin.tm.endpoint.ProjectEndpoint;
import ru.churkin.tm.endpoint.TaskEndpoint;
import ru.churkin.tm.endpoint.UserEndpoint;
import ru.churkin.tm.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
public class Bootstrap{

    @Inject
    private IProjectEndpoint projectEndpoint;

    @Inject
    private ITaskEndpoint taskEndpoint;

    @Inject
    private IUserEndpoint userEndpoint;

    @Inject
    private ISessionEndpoint sessionEndpoint;


//    final UserEndpoint userEndpoint = new UserEndpoint();
//    final TaskEndpoint taskEndpoint = new TaskEndpoint();
//    final ProjectEndpoint projectEndpoint = new ProjectEndpoint();

    public Bootstrap() {
    }

    public void init() {

        Endpoint.publish("http://localhost:8080/TaskList/task?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/project?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/user?wsdl", userEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/session?wsdl", sessionEndpoint);

    }

//    @Override
//    public ConnectionProducer connDB() {
//        return connDB;
//    }
}
