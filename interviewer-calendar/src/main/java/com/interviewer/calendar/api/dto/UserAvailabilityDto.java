package com.interviewer.calendar.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.Temporal;

@Getter
@ToString
@Builder
public class UserAvailabilityDto {

    private LocalDate date;

    private LocalTime initialTime;

    private LocalTime  endTime;

    private String email;


}
