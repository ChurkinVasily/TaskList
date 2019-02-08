package ru.churkin.ui;

import java.io.IOException;

public interface Command {

    String name();

    String description();

    void execute() throws IOException;

}
