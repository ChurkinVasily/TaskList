package ru.churkin.ui;

import java.io.IOException;

public class HelpCommand extends CommandAbstract {

    @Override
    public String name() {
        return "help1";
    }

    @Override
    public String description() {
        return "show available action";
    }

    @Override
    public void execute() throws IOException {
//        Map<String, Command> commandList =
//        for (Map.Entry<String, Command> entry : commandList.entrySet()) {
//            Command com = entry.getValue();
//            System.out.println(entry.getKey() + " : " + com.description());
//        }

        System.out.println("help. I need somebody. Help");

    }
}
