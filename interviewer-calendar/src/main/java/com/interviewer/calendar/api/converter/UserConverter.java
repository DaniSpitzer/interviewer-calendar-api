package com.interviewer.calendar.api.converter;

import com.interviewer.calendar.api.dto.UserAvailabilityDto;
import com.interviewer.calendar.api.dto.UserCreateDto;
import com.interviewer.calendar.api.dto.UserOutDto;
import com.interviewer.calendar.api.model.UserAvailability;
import com.interviewer.calendar.api.model.Users;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    public Users fromUserCreateDtoToUsers(UserCreateDto userCreateDto){
        return Users.builder()
                .name(userCreateDto.getName())
                .email(userCreateDto.getEmail())
                .password(userCreateDto.getPassword())
                .userType(userCreateDto.getUserType())
                .build();
    }

    public UserOutDto fromUsersToUserOutDto (Users user){
        return UserOutDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .userType(user.getUserType())
                .build();
    }

    public UserAvailability fromUserAvailabilityDtoToUserAvailability (UserAvailabilityDto userAvailabilityDto, Users user){
        return UserAvailability.builder()
                .date(userAvailabilityDto.getDate())
                .endTime(userAvailabilityDto.getEndTime())
                .initialTime(userAvailabilityDto.getInitialTime())
                .user(user)
                .build();
    }

}
