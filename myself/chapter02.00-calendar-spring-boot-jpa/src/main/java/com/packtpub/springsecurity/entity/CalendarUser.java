package com.packtpub.springsecurity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "calendar_user")
public class CalendarUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 256, nullable = false, unique = true)
    private String email;

    @Column(length = 256, nullable = false)
    @JSONField(serialize = false)
    private String password;

    @Column(length = 256, nullable = false)
    private String firstName;

    @Column(length = 256, nullable = false)
    private String lastName;

    @JSONField(serialize = false)
    public String getName() {
        return getLastName() + ", " + getFirstName();
    }


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
        CalendarUser other = (CalendarUser) obj;
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