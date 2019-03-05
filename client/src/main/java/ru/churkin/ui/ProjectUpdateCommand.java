package ru.churkin.ui;


import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.ProjectDTO;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
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
    public void execute() throws IOException, Exception_Exception {
        ProjectDTO newProject = new ProjectDTO();
        System.out.println("enter project-name for update Project");
        String name = serviceLocator.getTerminalService().nextLine();
        System.out.println("enter new parameters: name, description, time start, time finish");
        newProject.setName(serviceLocator.getTerminalService().nextLine());
        newProject.setDescription(serviceLocator.getTerminalService().nextLine());
        newProject.setTimeStart(serviceLocator.getTerminalService().nextLine());
        newProject.setTimeFinish(serviceLocator.getTerminalService().nextLine());
        boolean isUpdate = serviceLocator.getProjectEndpoint().updateProject(name,
                newProject.getName(),
                newProject.getDescription(),
                newProject.getTimeStart(),
                newProject.getTimeFinish());
        if (isUpdate) {
            System.out.println("project успешно обновлен");
        } else {
            System.out.println("не удалось обновить Project. пустое или несуществующее имя");
        }
    }
}
