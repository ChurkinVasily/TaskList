package ru.churkin.tm.boot;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.churkin.tm.api.IProjectEndpoint;
import ru.churkin.tm.api.ISessionEndpoint;
import ru.churkin.tm.api.ITaskEndpoint;
import ru.churkin.tm.api.IUserEndpoint;

import javax.xml.ws.Endpoint;

@Controller
@NoArgsConstructor
public class Bootstrap{

    @Autowired
    private IProjectEndpoint projectEndpoint;

    @Autowired
    private ITaskEndpoint taskEndpoint;

    @Autowired
    private IUserEndpoint userEndpoint;

    @Autowired
    private ISessionEndpoint sessionEndpoint;

    public void init() {

        Endpoint.publish("http://localhost:8080/TaskList/task?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/project?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/user?wsdl", userEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/session?wsdl", sessionEndpoint);

    }
}
