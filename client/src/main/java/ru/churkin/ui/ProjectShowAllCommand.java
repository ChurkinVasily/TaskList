package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.ProjectDTO;

import java.util.List;

public class ProjectShowAllCommand extends AbstractCommand {

    @Override
    public boolean isAuth() {
        return true;
    }

    @Override
    public String name() {
        return "shap";
    }

    @Override
    public String description() {
        return "SHow All Projects";
    }

    @Override
    public void execute() throws Exception_Exception {
        List<ProjectDTO> projects = serviceLocator.getProjectEndpoint().getAllProjects();
        if (projects != null) {
            for (ProjectDTO currentProject : projects) {
                System.out.println("Project{" +
                        "id='" + currentProject.getId() + '\'' +
                        ", name='" + currentProject.getName() + '\'' +
                        ", description='" + currentProject.getDescription() + '\'' +
                        ", timeStart='" + currentProject.getTimeStart() + '\'' +
                        ", timeFinish='" + currentProject.getTimeFinish() + '\'' +
                        '}');
            }
        } else {
            System.out.println("список проектов пуст");
        }
    }
}
