package ru.churkin.tm.boot;

import ru.churkin.tm.api.*;
import ru.churkin.tm.endpoint.ProjectEndpoint;
import ru.churkin.tm.endpoint.TaskEndpoint;
import ru.churkin.tm.endpoint.UserEndpoint;
import ru.churkin.tm.entity.Project;
import ru.churkin.tm.entity.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Persistence;
import javax.xml.ws.Endpoint;
import java.sql.SQLException;

@ApplicationScoped
public class Bootstrap{

    @Inject
    private ProjectService projectService;

    @Inject
    private IProjectEndpoint projectEndpoint;

    @Inject
    private ITaskEndpoint taskEndpoint;

    @Inject
    private IUserEndpoint userEndpoint;

    @Inject
    private ISessionEndpoint sessionEndpoint;

    @PostConstruct
    private void initq() throws SQLException {
        projectService.pers(new Project());
    }
//        projectService.getProjectAll();
//
////        Persistence.createEntityManagerFactory("TASKList");
//    }


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
}
