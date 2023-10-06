package com.tryOne.AuthonBack.controllers.rest.userRestController;

import com.tryOne.AuthonBack.DTO.security.RegistrationDto;
import com.tryOne.AuthonBack.Services.Security.AuthenticationServiceSignUp;
import com.tryOne.AuthonBack.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationSignUpController {

    @Autowired
    private AuthenticationServiceSignUp authenticationServiceSignUp;

    @PostMapping("/register")
    //map endpoints
    public User newUser(@RequestBody RegistrationDto registrationDto){
        return authenticationServiceSignUp.registerUser(
                registrationDto.getUserName(),
                registrationDto.getPassword(),
                null,
                null,
                null);

    }


}
