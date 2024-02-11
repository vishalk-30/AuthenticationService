package org.scaler.userloginservice.controller;

import lombok.AllArgsConstructor;
import org.scaler.userloginservice.dtos.CreateUserDto;
import org.scaler.userloginservice.dtos.LoginDto;
import org.scaler.userloginservice.dtos.ResponseUserDto;
import org.scaler.userloginservice.exception.InvalidEmailException;
import org.scaler.userloginservice.exception.UserAlreadyAvailableException;
import org.scaler.userloginservice.models.User;
import org.scaler.userloginservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @PostMapping
    public ResponseUserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }


}
