package com.packtpub.springsecurity.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "When is required")
    private Date time;

    @Column(length = 256)
    @NotEmpty(message = "Summary is required")
    private String summary;

    @Column(length = 256, nullable = false)
    @NotEmpty(message = "Description is required")
    private String description;

    @OneToOne
    @JoinColumn(name = "owner")
    private CalendarUser owner;

    @OneToOne
    @JoinColumn(name = "attendee")
    private CalendarUser attendee;

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Event other = (Event) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        return true;
    }
}