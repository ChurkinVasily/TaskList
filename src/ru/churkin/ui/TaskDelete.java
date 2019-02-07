package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskDelete implements Command {

    private Map<String, Task> taskMap = new HashMap<>();

    @Override
    public String name() {
        return "taskDel";
    }

    @Override
    public String description() {
        return "Task remove";
    }

    @Override
    public Object execute() throws IOException {
        System.out.println("enter task id for remove");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String id = reader.readLine();
        taskMap.remove(id);
        System.out.println("successful remove");
        reader.close();
        return true;
    }
}
