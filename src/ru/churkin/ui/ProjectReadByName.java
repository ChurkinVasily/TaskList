package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.service.ProjectServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectReadByName implements Command {

    private BufferedReader reader;
    private ProjectServiceImpl projectServiceImpl;

    public ProjectReadByName(BufferedReader reader, ProjectServiceImpl projectServiceImpl) {
        this.reader = reader;
        this.projectServiceImpl = projectServiceImpl;
    }

    public ProjectReadByName() {
    }

    @Override
    public String name() {
        return "pf";
    }

    @Override
    public String description() {
        return "Project Find by name";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("для просмотра нужного проекта (project) введите его имя");
        String name = reader.readLine();
        try {
            System.out.println(projectServiceImpl.findProjectByName(name).toString());
        } catch (NullPointerException e) {
            System.out.println("нет проекта с таким именем");
        }
    }
}
