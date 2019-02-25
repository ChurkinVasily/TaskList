package ru.churkin;

import org.apache.ibatis.session.SqlSessionFactory;
import ru.churkin.api.Command;
import ru.churkin.api.ProjectService;
import ru.churkin.api.ServiceLocator;
import ru.churkin.api.TaskService;
import ru.churkin.entity.User;
import ru.churkin.repository.ConnectionDB;
import ru.churkin.service.ProjectServiceImpl;
import ru.churkin.service.TaskServiceImpl;
import ru.churkin.service.TerminalService;
import ru.churkin.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap implements ServiceLocator {

    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final ServiceLocator serviceLocator = this;
    final TerminalService terminalService = new TerminalService(reader);

    final ConnectionDB connMyBatis = new ConnectionDB();
    final SqlSessionFactory sqlSessionFactory = connMyBatis.getSqlSessionFactory();
    final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(sqlSessionFactory);
    final ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl(sqlSessionFactory);
    final UserServiceImpl userServiceImpl = new UserServiceImpl(sqlSessionFactory);

    final Map<String, Command> commandList = new HashMap<>();

    private Class[] cls;

    public Bootstrap() {
    }

    public void init(Class[] cls) throws IOException, IllegalAccessException, InstantiationException, SQLException {

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

    @Override
    public TerminalService getTerminalService() {
        return terminalService;
    }

    @Override
    public Map<String, Command> getCommandMap() {
        return commandList;
    }

    public void execute(Command command) throws IOException, SQLException {
        User user = serviceLocator.getUserService().currentUser;
        if (!command.isAuth() || (command.isAuth() && serviceLocator.getUserService().validateUser(user))) {
            command.execute();
        } else System.out.println("требуется авторизация");
    }


}
