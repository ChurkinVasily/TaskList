package ru.churkin.tm.ui;

import ru.churkin.tm.api.Command;

import java.util.Map;

public class HelpCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return false;
    }

    @Override
    public String name() {
        return "help";
    }

    @Override
    public String description() {
        return "show available action";
    }

    @Override
    public void execute() {
        Map<String, Command> map = serviceLocator.getCommandMap();
        for (Map.Entry<String, Command> entry : map.entrySet()) {
            Command com = entry.getValue();
            System.out.println(com.name() + " : " + com.description());
        }
    }
}
