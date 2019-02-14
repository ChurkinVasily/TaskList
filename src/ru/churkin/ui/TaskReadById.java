package ru.churkin.ui;

import java.io.IOException;

public class TaskReadById extends CommandAbstract {

    @Override
    public String name() {
        return "tfid";
    }

    @Override
    public String description() {
        return "Task Find by ID";
    }

    @Override
    public void execute() throws IOException {


    }
}
