package ru.chirkin.ui;

import ru.chirkin.entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskCreate implements Command{

    private Task newTask = new Task();

   @Override
    public String name() {
        return "taskCreate";
    }

    @Override
    public String description() {
        return "Create new task";
    }

    @Override
    public Object execute() throws IOException {
        System.out.println("enter new task parameters: name, description, timeStart, timeFinish");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        newTask.setName(reader.readLine());
        newTask.setDescription(reader.readLine());
        newTask.setTimeFin(reader.readLine());
        newTask.setTimeFin(reader.readLine());
        reader.close();
        return newTask;
    }
}
