package com.interviewer.calendar.api.repository;

import com.interviewer.calendar.api.model.UserAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAvailabilityRepository extends JpaRepository<UserAvailability, Long> {
}
