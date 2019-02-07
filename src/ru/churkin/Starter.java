package ru.churkin;

import ru.churkin.ui.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Starter {

    public void init() throws IOException {
        final TaskCreate taskCreate = new TaskCreate();
        final TaskReadByID taskReadByID = new TaskReadByID();
        final TaskUpdate taskUpdate = new TaskUpdate();
        final TaskDelete taskDelete = new TaskDelete();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Object> commandList = new HashMap<>();
        commandList.put(taskCreate.name(), taskCreate.description());
        commandList.put(taskReadByID.name(), taskReadByID.description());
        commandList.put(taskUpdate.name(), taskUpdate.description());
        commandList.put(taskDelete.name(), taskDelete.description());


        System.out.println("enter 'help'");

        if ("help".equals(reader.readLine())) {
            for (Map.Entry<String, Object> entry : commandList.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }





//        if ("help".equals(reader.readLine())) {
//            for (Map.Entry<String, Object> entry : commandMap.entrySet())
//            {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }
//        }
    }
}
