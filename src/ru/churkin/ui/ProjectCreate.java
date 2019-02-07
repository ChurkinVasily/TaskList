package ru.churkin.ui;

import ru.churkin.entity.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProjectCreate implements Command {

    private Project newProject = new Project();

    @Override
    public String name() {
        return "projectCreate";
    }

    @Override
    public String description() {
        return "create Project";
    }

    @Override
    public Object execute() throws IOException {
        System.out.println("enter project parameters: name, description, start time, finish time");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        newProject.setName(reader.readLine());
        newProject.setDescription(reader.readLine());
        newProject.setTimeStart(reader.readLine());
        newProject.setTimeFinish(reader.readLine());
        reader.close();
        return newProject;
    }
}
