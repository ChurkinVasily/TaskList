package ru.churkin.tm.boot;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.churkin.tm.api.IProjectEndpoint;
import ru.churkin.tm.api.ISessionEndpoint;
import ru.churkin.tm.api.ITaskEndpoint;
import ru.churkin.tm.api.IUserEndpoint;

//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
import javax.xml.ws.Endpoint;


//@Component
@Controller
@NoArgsConstructor
public class Bootstrap{

//    @Inject
    @Autowired
    private IProjectEndpoint projectEndpoint;

//    @Inject
    @Autowired
    private ITaskEndpoint taskEndpoint;

//    @Inject
    @Autowired
    private IUserEndpoint userEndpoint;

//    @Inject
    @Autowired
    private ISessionEndpoint sessionEndpoint;

    public void init() {

        Endpoint.publish("http://localhost:8080/TaskList/task?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/project?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/user?wsdl", userEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/session?wsdl", sessionEndpoint);

    }
}
