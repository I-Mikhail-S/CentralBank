package ru.ivanchin.centralbank.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivanchin.centralbank.dto.request.AuthenticationRequest;
import ru.ivanchin.centralbank.dto.request.UserRequest;
import ru.ivanchin.centralbank.dto.response.UserResponse;
import ru.ivanchin.centralbank.exception.UserAlreadyExistException;
import ru.ivanchin.centralbank.mapper.UserMapper;
import ru.ivanchin.centralbank.repository.UserRepository;
import ru.ivanchin.centralbank.user.Role;
import ru.ivanchin.centralbank.user.User;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserService not found user by username(email)."));
    }

    public UserResponse addUser(AuthenticationRequest authenticationRequest) throws UserAlreadyExistException {
        if (userRepository.findByEmail(authenticationRequest.getUsername()).isPresent())
            throw new UserAlreadyExistException();

        User user = userMapper.toEntity(authenticationRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>() {{
            add(Role.USER);
        }});
        userRepository.save(user);

        return new UserResponse(user.getName(), user.getEmail(), user.getRoles());
    }
}
