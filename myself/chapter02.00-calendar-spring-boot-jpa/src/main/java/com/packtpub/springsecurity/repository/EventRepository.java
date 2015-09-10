package com.packtpub.springsecurity.repository;


import com.packtpub.springsecurity.entity.CalendarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<CalendarUser, Long> {
}
