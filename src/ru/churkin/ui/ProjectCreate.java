package ru.churkin.ui;

import ru.churkin.entity.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProjectCreate implements Command {

    private BufferedReader reader;

    @Override
    public String name() {
        return "projectCreate";
    }

    @Override
    public String description() {
        return "create Project";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("enter project parameters: name, description, start time, finish time");
//        newProject.setName(reader.readLine());
//        newProject.setDescription(reader.readLine());
//        newProject.setTimeStart(reader.readLine());
//        newProject.setTimeFinish(reader.readLine());
    }
}
