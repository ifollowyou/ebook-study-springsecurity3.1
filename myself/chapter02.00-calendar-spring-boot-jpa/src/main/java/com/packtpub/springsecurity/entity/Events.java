package com.packtpub.springsecurity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(length = 256)
    private String summary;

    @Column(length = 256, nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name="owner")
    private CalendarUsers owner;

    @OneToOne
    @JoinColumn(name="attendee")
    private CalendarUsers attendee;
}
