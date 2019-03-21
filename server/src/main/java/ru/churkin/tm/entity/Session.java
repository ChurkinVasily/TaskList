package ru.churkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sessions")
public class Session {

    @Id
    private String id;

    @Nullable
    private String signature;

    @Nullable
    private String userId;

    public Session(String userId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
    }
}
