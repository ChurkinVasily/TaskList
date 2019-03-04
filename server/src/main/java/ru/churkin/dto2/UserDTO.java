package ru.churkin.dto2;

import ru.churkin.entity.User;

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
