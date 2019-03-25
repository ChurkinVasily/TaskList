package ru.churkin.tm.boot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

@Component
@NoArgsConstructor
@Getter
public class BootstrapClient implements ServiceLocator {

    private final Map<String, Command> commandList = new HashMap<>();

    private Class[] cls;

    @Setter
    private Session currentSession;

    private final ServiceLocator serviceLocator = this;

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final TerminalService terminalService = new TerminalService(reader);

    public String nextLine() throws IOException {
        return reader.readLine().trim().toLowerCase();
    }

    @Autowired
    private TaskEndpoint taskEndpoint;

    @Autowired
    private ProjectEndpoint projectEndpoint;

    @Autowired
    private UserEndpoint userEndpoint;

    @Autowired
    private SessionEndpoint sessionEndpoint;

    @Override
    public Map<String, Command> getCommandMap() {
        return commandList;
    }

    public void init(Class[] cls) throws IOException, IllegalAccessException, InstantiationException, SQLException, Exception_Exception {
        this.cls = cls;

        for (Class cl : cls) {
            Command com = (Command) cl.newInstance();
            com.setLocator(this);
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
        if (currentSession == null) return;
        sessionEndpoint.deleteSessionById(currentSession.getId());
        currentSession = null;
    }

    public void execute(Command command) throws IOException, SQLException, Exception_Exception {
        Session session = getCurrentSession();
        if (!command.isAuth() || (command.isAuth() && sessionEndpoint.validate(session))) {
            command.execute();
        } else System.out.println("требуется авторизация");
    }

}
