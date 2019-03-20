package ru.churkin.tm;

import ru.churkin.tm.api.Command;
import ru.churkin.tm.api.ServiceLocator;
import ru.churkin.tm.api.TerminalService;
import ru.churkin.tm.endpoint.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BootstrapClient implements ServiceLocator {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private final ServiceLocator serviceLocator = this;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final ProjectEndpointService projectEndpointService = new ProjectEndpointService();
    private final ProjectEndpoint projectEndpoint = projectEndpointService.getProjectEndpointPort();

    private final TaskEndpointService taskEndpointService = new TaskEndpointService();
    private final TaskEndpoint taskEndpoint = taskEndpointService.getTaskEndpointPort();

    private final UserEndpointService userEndpointService = new UserEndpointService();
    private final UserEndpoint userEndpoint = userEndpointService.getUserEndpointPort();

    private final SessionEndpointService sessionEndpointService = new SessionEndpointService();
    private final SessionEndpoint sessionEndpoint = sessionEndpointService.getSessionEndpointPort();

    private final TerminalService terminalService = new TerminalService(reader);

    public String nextLine() throws IOException {
        return reader.readLine().trim().toLowerCase();
    }

    private final Map<String, Command> commandList = new HashMap<>();

    private Class[] cls;

    private Session currentSession;

    @Override
    public Map<String, Command> getCommandMap() {
        return commandList;
    }

    public void init(Class[] cls) throws IOException, IllegalAccessException, InstantiationException, SQLException, Exception_Exception {
        this.cls = cls;

        for (Class cl : cls) {
            Command com = (Command) cl.newInstance();
            com.setLocator(serviceLocator);
            commandList.put(com.name(), com);
        }

        String userInput = reader.readLine();
        while (!"exit".equals(userInput)) {
            if (commandList.containsKey(userInput)) {
                Command cmnd = commandList.get(userInput);
                this.execute(cmnd);
            } else {
                System.out.println("несуществующая команда");
            }
            userInput = reader.readLine();
        }
        Session sessionCur = currentSession;
        serviceLocator.getSessionEndpoint().deleteSession(sessionCur);
        currentSession = null;
    }

    public void execute(Command command) throws IOException, SQLException, Exception_Exception {
//        UserDTO user = serviceLocator.getUserEndpoint().getCurrentUser();
        Session session = getCurrentSession();
//        if (!command.isAuth() || (command.isAuth() && serviceLocator.getUserEndpoint().validateUser(user.getName(), user.getPassword()))) {
        if (!command.isAuth() || (command.isAuth() && serviceLocator.getSessionEndpoint().validate(session))) {
            command.execute();
        } else System.out.println("требуется авторизация");
    }

    @Override
    public TaskEndpoint getTaskEndpoint() {
        return taskEndpoint;
    }

    @Override
    public ProjectEndpoint getProjectEndpoint() {
        return projectEndpoint;
    }

    @Override
    public UserEndpoint getUserEndpoint() {
        return userEndpoint;
    }

    @Override
    public SessionEndpoint getSessionEndpoint() {
        return sessionEndpoint;
    }

    @Override
    public TerminalService getTerminalService() {
        return terminalService;
    }

    @Override
    public Session getCurrentSession() {
        return currentSession;
    }

    @Override
    public void setCurrentSession(Session session) {
        this.currentSession = session;
    }
}
