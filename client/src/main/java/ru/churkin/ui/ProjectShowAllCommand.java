package ru.churkin.ui;

import ru.churkin.endpoint.Exception_Exception;
import ru.churkin.endpoint.Project;

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
        List<Project> projects = serviceLocator.getProjectEndpoint().getAllProjects();
        if (projects != null) {
            for (Project project : projects) {
                System.out.println(project);
            }
        } else {
            System.out.println("список проектов пуст");
        }
    }
}
