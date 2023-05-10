package com.interviewer.calendar.api.repository;

import com.interviewer.calendar.api.model.UserAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface UserAvailabilityRepository extends JpaRepository<UserAvailability, Long> {

    @Query("SELECT ua FROM UserAvailability ua " +
            "JOIN ua.user u " +
            "WHERE ua.initialTime = :initialTime " +
            "AND ua.endTime = :endTime " +
            "AND ua.date = :date " +
            "AND u.userType = 'INTERVIEWER'")
    List<UserAvailability> getSlots(@Param("initialTime") LocalTime initialTime,
                                    @Param("endTime") LocalTime endTime,
                                    @Param("date") LocalDate date);


}
