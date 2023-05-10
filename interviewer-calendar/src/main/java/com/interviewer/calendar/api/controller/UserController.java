package com.interviewer.calendar.api.controller;

import com.interviewer.calendar.api.dto.UserAvailabilityDto;
import com.interviewer.calendar.api.dto.UserCreateDto;
import com.interviewer.calendar.api.dto.UserOutDto;
import com.interviewer.calendar.api.model.UserAvailability;
import com.interviewer.calendar.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<UserOutDto> addUser(@RequestBody UserCreateDto newUserCreateDto){
        UserOutDto userOutDto = userService.addUser(newUserCreateDto);
        return new ResponseEntity<>(userOutDto, HttpStatus.CREATED);
    }

    @PostMapping("/register-user-availability")
    public ResponseEntity<Void> addAvailability(@RequestBody UserAvailabilityDto newUserAvailabilityDto){
        userService.addAvailability(newUserAvailabilityDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/interviewer-available")
    public ResponseEntity<List<UserAvailabilityDto>> getInterviewersAvailable(@RequestBody UserAvailabilityDto userAvailabilityDto){
        List<UserAvailabilityDto> availableSlots = userService.addInterviewersAvailable(userAvailabilityDto);
        System.out.println(availableSlots);
        return new ResponseEntity<>(availableSlots, HttpStatus.OK);
    }


}
