package ru.churkin.dto;

import ru.churkin.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDTO {

    private String id;
    private String name;
    private String password;

    public UserDTO(String name) {
        this.name = name;
    }

    public UserDTO(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserDTO() {
    }

    public UserDTO(final User user) {
        if (user == null) return;
        id = user.getId();
        name = user.getName();
        password = user.getPassword();
    }

    public static UserDTO toDTO(final User user) {
        if (user == null) return null;
        return new UserDTO(user);
    }

    public static List<UserDTO> toDTO(final Collection<User> users) {
        if (users == null || users.isEmpty()) return Collections.emptyList();
        List<UserDTO> list = new ArrayList<>();
        for (User user : users) {
            list.add(new UserDTO(user));
        }
        return list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
