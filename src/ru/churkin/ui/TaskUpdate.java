package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskUpdate implements Command{

    private Task newTask = new Task();

    @Override
    public String name() {
        return "taskUpd";
    }

    @Override
    public String description() {
        return "Update task";
    }

    @Override
    public Object execute() throws IOException {
        System.out.println("enter id for update Task");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        newTask.setId(reader.readLine());
        System.out.println("enter new parameters: name, description, time start, time finish, project ID");
        newTask.setName(reader.readLine());
        newTask.setDescription(reader.readLine());
        newTask.setTimeStart(reader.readLine());
        newTask.setTimeFinish(reader.readLine());
        newTask.setProjectId(reader.readLine());
        reader.close();
        return newTask;

    }
}
