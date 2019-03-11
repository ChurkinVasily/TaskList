package ru.churkin.tm.ui;


import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.ProjectDTO;

import java.io.IOException;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
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
    public void execute() throws IOException, Exception_Exception {
        ProjectDTO newProject = new ProjectDTO();
        System.out.println("enter new project parameters: name");
        newProject.setName(serviceLocator.getTerminalService().nextLine());
        boolean isCreate = serviceLocator.getProjectEndpoint().createProject(newProject.getName());
        if (isCreate) {
            System.out.println("проет (Project) успешно создан");
        } else System.out.println("вы задали существующее или пустое имя проекта");

    }
}
