package com.interviewer.calendar.api.service;

import com.interviewer.calendar.api.converter.UserConverter;
import com.interviewer.calendar.api.dto.UserAvailabilityDto;
import com.interviewer.calendar.api.dto.UserCreateDto;
import com.interviewer.calendar.api.dto.UserOutDto;
import com.interviewer.calendar.api.model.UserAvailability;
import com.interviewer.calendar.api.model.Users;
import com.interviewer.calendar.api.repository.UserAvailabilityRepository;
import com.interviewer.calendar.api.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.temporal.*;

@Service
public class UserService {

    private UserConverter userConverter;
    private UserRepository userRepository;
    private UserAvailabilityRepository userAvailabilityRepository;

    @Autowired
    public UserService(UserConverter userConverter, UserRepository userRepository, UserAvailabilityRepository userAvailabilityRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
        this.userAvailabilityRepository = userAvailabilityRepository;
    }

    public UserOutDto addUser(UserCreateDto newUserCreateDto) {
        Users newUser = userConverter.fromUserCreateDtoToUsers(newUserCreateDto);
        userRepository.save(newUser);
        return userConverter.fromUsersToUserOutDto(newUser);
    }

    public void addAvailability(UserAvailabilityDto newUserAvailabilityDto) {
        Users userByEmail = userRepository.findByEmail(newUserAvailabilityDto.getEmail());
        UserAvailability userAvailability = userConverter.fromUserAvailabilityDtoToUserAvailability(newUserAvailabilityDto, userByEmail);
        System.out.println(userByEmail.getEmail());
        Long availabilityDuration = java.time.Duration.between(newUserAvailabilityDto.getInitialTime(),newUserAvailabilityDto.getEndTime()).toHours();
        if( availabilityDuration > 1){
            System.out.println("entro no if");
            LocalTime initialHour = newUserAvailabilityDto.getInitialTime();
            for(int i = 1; i < availabilityDuration; i++){
                TemporalUnit hourUnit = ChronoUnit.HOURS;
                LocalTime incrementalHour = newUserAvailabilityDto.getInitialTime().plus(i, hourUnit);
                UserAvailability slot = UserAvailability.builder()
                        .date(newUserAvailabilityDto.getDate())
                        .initialTime(initialHour)
                        .endTime(incrementalHour)
                        .user(userByEmail)
                        .build();
                userAvailabilityRepository.save(slot);
                initialHour = incrementalHour;
            }
        }
        userAvailabilityRepository.save(userAvailability);
    }
}
