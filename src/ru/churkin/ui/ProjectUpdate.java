package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.entity.Project;
import ru.churkin.service.ProjectServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectUpdate implements Command {

    private BufferedReader reader;
    private ProjectServiceImpl projectServiceImpl;

    public ProjectUpdate(BufferedReader reader, ProjectServiceImpl projectServiceImpl) {
        this.reader = reader;
        this.projectServiceImpl = projectServiceImpl;
    }

    public ProjectUpdate() {
    }

    @Override
    public String name() {
        return "pu";
    }

    @Override
    public String description() {
        return "Project Updating";
    }

    @Override
    public void execute() throws IOException {
        Project newProject = new Project();
        System.out.println("enter project-name for update Project");
        String name = reader.readLine();
        System.out.println("enter new parameters: name, description, time start, time finish");
        newProject.setName(reader.readLine());
        newProject.setDescription(reader.readLine());
        newProject.setTimeStart(reader.readLine());
        newProject.setTimeFinish(reader.readLine());
        boolean isUpdate = projectServiceImpl.updateProject(name, newProject);
        if (isUpdate) {
            System.out.println("project успешно обновлен");
        } else {
            System.out.println("не удалось обновить Project. пустое или несуществующее имя");
        }
    }
}
