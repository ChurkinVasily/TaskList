package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.entity.Project;
import ru.churkin.service.ProjectServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectCreate implements Command {

    private BufferedReader reader;
    private ProjectServiceImpl projectServiceImpl;

    public ProjectCreate(BufferedReader reader, ProjectServiceImpl projectServiceImpl) {
        this.reader = reader;
        this.projectServiceImpl = projectServiceImpl;
    }

    @Override
    public String name() {
        return "pc";
    }

    @Override
    public String description() {
        return "Project Creation";
    }

    @Override
    public void execute() throws IOException {
        Project newProject = new Project();
        System.out.println("enter new project parameters: name, description, timeStart, timeFinish");
        newProject.setName(reader.readLine());
        newProject.setDescription(reader.readLine());
        newProject.setTimeStart(reader.readLine());
        newProject.setTimeFinish(reader.readLine());
        boolean isCreate = projectServiceImpl.createProject(newProject);
        if (isCreate)  { System.out.println("проет (Project) успешно создан");}
        else System.out.println("вы задали существующее или пустое имя проекта");

    }
}
