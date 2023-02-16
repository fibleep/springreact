package com.book.springreact.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable=false,updatable=false)
    private Long id;
    @Column(nullable=false,unique = true)
    private String username;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
