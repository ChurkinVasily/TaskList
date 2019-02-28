package ru.churkin.ui;

import ru.churkin.entity.Project;

import java.sql.SQLException;
import java.util.Map;

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
    public void execute() throws SQLException {
        Map<String, Project> projects = serviceLocator.getProjectService().getAllProjects();
        if (projects != null) {
            for (Map.Entry<String, Project> entry : projects.entrySet()) {
                System.out.println(entry.getValue());
            }
        } else {
            System.out.println("список проектов пуст");
        }
    }
}
