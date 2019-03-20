package ru.churkin.tm.boot;

import lombok.NoArgsConstructor;
import ru.churkin.tm.api.IProjectEndpoint;
import ru.churkin.tm.api.ISessionEndpoint;
import ru.churkin.tm.api.ITaskEndpoint;
import ru.churkin.tm.api.IUserEndpoint;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
@NoArgsConstructor
public class Bootstrap{

//    @Inject
//    private ProjectService projectService;

    @Inject
    private IProjectEndpoint projectEndpoint;

    @Inject
    private ITaskEndpoint taskEndpoint;

    @Inject
    private IUserEndpoint userEndpoint;

    @Inject
    private ISessionEndpoint sessionEndpoint;

//    @PostConstruct
////    private void initq() throws SQLException {
////        projectService.pers(new Project());
////    } /// --------тестирование транзакций

    public void init() {

        Endpoint.publish("http://localhost:8080/TaskList/task?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/project?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/user?wsdl", userEndpoint);
        Endpoint.publish("http://localhost:8080/TaskList/session?wsdl", sessionEndpoint);

    }
}
