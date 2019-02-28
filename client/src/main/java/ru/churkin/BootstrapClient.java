package ru.churkin;

import ru.churkin.api.Command;
import ru.churkin.api.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BootstrapClient implements ServiceLocator {

    final ServiceLocator serviceLocator = this;
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String nextLine() throws IOException {
        return reader.readLine().trim().toLowerCase();
    }

    final Map<String, Command> commandList = new HashMap<>();

    private Class[] cls;

    @Override
    public Map<String, Command> getCommandMap() {
        return commandList;
    }

    public void init(Class[] cls) throws IOException, IllegalAccessException, InstantiationException {
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

    public void execute(Command command) throws IOException {
        User user = serviceLocator.getUserService().currentUser;
        if (!command.isAuth() || (command.isAuth() && serviceLocator.getUserService().validateUser(user))) {
            command.execute();
        } else System.out.println("требуется авторизация");
    }



}
