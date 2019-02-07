package ru.chirkin;

import ru.chirkin.ui.TaskCreate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Starter {

    public void init() throws IOException {
        final TaskCreate taskCreate = new TaskCreate();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Object> commandMap = new HashMap<>();
        commandMap.put(taskCreate.name(), taskCreate);

        System.out.println("enter 'help'");

        if ("help".equals(reader.readLine())) {
            for (Map.Entry<String, Object> entry : commandMap.entrySet())
            {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
