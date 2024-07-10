package ru.ivanchin.centralbank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivanchin.centralbank.dto.request.AuthenticationRequest;
import ru.ivanchin.centralbank.dto.request.UserRequest;
import ru.ivanchin.centralbank.dto.response.AuthenticationResponse;
import ru.ivanchin.centralbank.exception.RoleNotFoundException;
import ru.ivanchin.centralbank.exception.UserAlreadyExistException;
import ru.ivanchin.centralbank.exception.UserNotFoundException;
import ru.ivanchin.centralbank.repository.RoleRepository;
import ru.ivanchin.centralbank.repository.UserRepository;
import ru.ivanchin.centralbank.user.Role;
import ru.ivanchin.centralbank.user.User;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserRequest request) throws UserAlreadyExistException, RoleNotFoundException {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw new UserAlreadyExistException();

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(new HashSet<>() { {
                    add( roleService.finedRoleByName(Role.USER.name()) );
                } })
                .build();
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authentication(AuthenticationRequest request) throws UserNotFoundException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

}
