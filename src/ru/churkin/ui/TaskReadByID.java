package ru.churkin.ui;

import ru.churkin.entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskReadByID implements Command{

    private Map<String, Task> tempMap = new HashMap<>();

    @Override
    public String name() {
        return "taskReadByID";
    }

    @Override
    public String description() {
        return "Read task by ID";
    }

    @Override
    public Object execute() throws IOException {
        System.out.println("enter id");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String id = reader.readLine();
        reader.close();
        return tempMap.get(id);
    }
}
