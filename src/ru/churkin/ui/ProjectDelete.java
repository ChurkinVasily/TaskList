package ru.churkin.ui;

import ru.churkin.api.Command;
import ru.churkin.service.ProjectServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectDelete implements Command {

    private BufferedReader reader;
    private ProjectServiceImpl projectServiceImpl;

    public ProjectDelete(BufferedReader reader, ProjectServiceImpl projectServiceImpl) {
        this.reader = reader;
        this.projectServiceImpl = projectServiceImpl;
    }

    @Override
    public String name() {
        return "pd";
    }

    @Override
    public String description() {
        return "Project Deleting";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("введите имя проекта (project) для удаления");
        String id = reader.readLine();
        boolean isDelete = projectServiceImpl.deleteProject(id);
        if (isDelete) System.out.println("успешно удалено");
        else System.out.println("ошибка удаления. пустое или не существующее имя");
    }
}
