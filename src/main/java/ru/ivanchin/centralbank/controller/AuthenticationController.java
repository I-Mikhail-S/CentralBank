package ru.ivanchin.centralbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanchin.centralbank.dto.request.AuthenticationRequest;
import ru.ivanchin.centralbank.dto.request.UserRequest;
import ru.ivanchin.centralbank.dto.response.AuthenticationResponse;
import ru.ivanchin.centralbank.exception.RoleNotFoundException;
import ru.ivanchin.centralbank.exception.UserAlreadyExistException;
import ru.ivanchin.centralbank.exception.UserNotFoundException;
import ru.ivanchin.centralbank.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @RequestMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserRequest request
    ) throws UserAlreadyExistException, RoleNotFoundException {
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }

    @RequestMapping("/authenticated")
    public ResponseEntity<AuthenticationResponse> authenticated(
            @RequestBody AuthenticationRequest request
    ) throws UserNotFoundException {
        return new ResponseEntity<>(authenticationService.authentication(request), HttpStatus.OK);
    }

}
