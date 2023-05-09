package com.interviewer.calendar.api.repository;

import com.interviewer.calendar.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail (String email);

}
