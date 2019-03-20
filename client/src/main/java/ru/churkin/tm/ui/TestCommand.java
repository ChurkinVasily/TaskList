package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;

import java.io.IOException;
import java.sql.SQLException;

public class TestCommand extends AbstractCommand {
    @Override
    public boolean isAuth() {
        return false;
    }

    @Override
    public String name() {
        return "test";
    }

    @Override
    public String description() {
        return "test command";
    }

    @Override
    public void execute() throws IOException, SQLException, Exception_Exception {

        System.out.println("test command finish");
        //System.out.println(serviceLocator.getTaskEndpoint().deleteTask("task1_1"));

    }
}
