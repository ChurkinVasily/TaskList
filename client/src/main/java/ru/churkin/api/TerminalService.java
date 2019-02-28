package ru.churkin.api;

import java.io.BufferedReader;
import java.io.IOException;

public class TerminalService {

    private BufferedReader reader;

    public TerminalService(BufferedReader reader) {
        this.reader = reader;
    }

    public String nextLine() throws IOException {
        return reader.readLine().trim().toLowerCase();
    }
}
