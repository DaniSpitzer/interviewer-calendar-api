package com.interviewer.calendar.api.dto;

import com.interviewer.calendar.api.model.UserType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
public class UserCreateDto {

    private String name;
    private String email;
    private String password;
    private UserType userType;

}
