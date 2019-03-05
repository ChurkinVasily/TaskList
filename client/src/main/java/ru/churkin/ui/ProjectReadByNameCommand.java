package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.ProjectDTO;

import java.io.IOException;

public class ProjectReadByNameCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
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
        String name = serviceLocator.getTerminalService().nextLine();
        try {
            ProjectDTO currentProject = serviceLocator.getProjectEndpoint().findProjectByName(name);
            System.out.println("Project{" +
                    "id='" + currentProject.getId() + '\'' +
                    ", name='" + currentProject.getName() + '\'' +
                    ", description='" + currentProject.getDescription() + '\'' +
                    ", timeStart='" + currentProject.getTimeStart() + '\'' +
                    ", timeFinish='" + currentProject.getTimeFinish() + '\'' +
                    '}');
        } catch (NullPointerException | Exception_Exception e) {
            System.out.println("нет проекта с таким именем");
        }
    }
}
