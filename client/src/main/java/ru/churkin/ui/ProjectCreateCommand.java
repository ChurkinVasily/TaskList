package ru.churkin.ui;


import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.Project;

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
        Project newProject = new Project();
//        System.out.println("enter new project parameters: name, description, timeStart, timeFinish");
        System.out.println("enter new project parameters: name");
        newProject.setName(serviceLocator.getTerminalService().nextLine());
//        newProject.setDescription(serviceLocator.getTerminalService().nextLine());
//        newProject.setTimeStart(serviceLocator.getTerminalService().nextLine());
//        newProject.setTimeFinish(serviceLocator.getTerminalService().nextLine());
        boolean isCreate = serviceLocator.getProjectEndpoint().createProject(newProject.getName());
        if (isCreate) {
            System.out.println("проет (Project) успешно создан");
        } else System.out.println("вы задали существующее или пустое имя проекта");

    }
}
