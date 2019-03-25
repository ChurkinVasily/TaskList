package ru.churkin.tm.ui;

import ru.churkin.tm.endpoint.Exception_Exception;
import ru.churkin.tm.endpoint.ProjectDTO;
import ru.churkin.tm.endpoint.Session;

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
    public void execute() throws IOException, Exception_Exception {
        Session currentSession = serviceLocator.getCurrentSession();
        validateSession(currentSession);

        System.out.println("для просмотра нужного проекта (project) введите его имя");
        String name = serviceLocator.getTerminalService().nextLine();
        ProjectDTO currentProject = serviceLocator.getProjectEndpoint().findProjectByName(name);
        if (currentProject == null) {
            System.out.println("нет проекта с таким именем");
            return;
        }
        System.out.println("Project{" +
                "id='" + currentProject.getId() + '\'' +
                ", name='" + currentProject.getName() + '\'' +
                ", description='" + currentProject.getDescription() + '\'' +
                ", timeStart='" + currentProject.getTimeStart() + '\'' +
                ", timeFinish='" + currentProject.getTimeFinish() + '\'' +
                '}');
    }
}
