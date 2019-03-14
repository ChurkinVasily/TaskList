package ru.churkin.tm.dto;

import lombok.Getter;
import lombok.Setter;
import ru.churkin.tm.entity.User;

import java.util.*;

@Getter
@Setter
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
}
