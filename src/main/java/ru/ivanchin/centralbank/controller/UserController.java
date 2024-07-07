package ru.ivanchin.centralbank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanchin.centralbank.dto.request.AuthenticationRequest;
import ru.ivanchin.centralbank.dto.response.UserResponse;
import ru.ivanchin.centralbank.exception.UserAlreadyExistException;
import ru.ivanchin.centralbank.service.UserService;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody AuthenticationRequest authenticationRequest) throws UserAlreadyExistException {
        return new ResponseEntity<>(userService.addUser(authenticationRequest), HttpStatus.CREATED);
    }

}
