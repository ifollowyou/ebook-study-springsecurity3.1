package com.packtpub.springsecurity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "calendar_users")
public class CalendarUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 256, nullable = false, unique = true)
    private String email;

    @Column(length = 256, nullable = false)
    private String password;

    @Column(length = 256, nullable = false)
    private String firstName;

    @Column(length = 256, nullable = false)
    private String lastName;
}
