package ru.churkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sessions")
public class Session {

    @Id
    private String id;

    private String signature;

    private String userId;

    public Session(String userId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
    }
}