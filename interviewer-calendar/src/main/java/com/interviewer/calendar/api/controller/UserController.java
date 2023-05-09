package com.interviewer.calendar.api.controller;

import com.interviewer.calendar.api.dto.UserAvailabilityDto;
import com.interviewer.calendar.api.dto.UserCreateDto;
import com.interviewer.calendar.api.dto.UserOutDto;
import com.interviewer.calendar.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("aqui");
        userService.addAvailability(newUserAvailabilityDto);
        System.out.println("chamei o serviço");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
