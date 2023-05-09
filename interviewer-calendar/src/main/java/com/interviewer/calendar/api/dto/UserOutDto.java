package com.interviewer.calendar.api.dto;

import com.interviewer.calendar.api.model.UserType;
import lombok.*;

@Getter
@Builder
@ToString
public class UserOutDto {

    private String name;
    private String email;
    private UserType userType;

}
