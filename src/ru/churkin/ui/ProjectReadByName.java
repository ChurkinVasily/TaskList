package ru.churkin.ui;

import java.io.IOException;

public class ProjectReadByName extends CommandAbstract {

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
            System.out.println(serviceLocator.getProjectService().findProjectByName(name).toString());
        } catch (NullPointerException e) {
            System.out.println("нет проекта с таким именем");
        }
    }
}
