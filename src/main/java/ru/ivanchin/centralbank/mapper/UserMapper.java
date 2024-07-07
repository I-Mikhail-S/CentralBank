package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.request.AuthenticationRequest;
import ru.ivanchin.centralbank.dto.request.UserRequest;
import ru.ivanchin.centralbank.user.User;

@Mapper(componentModel="spring")
public interface UserMapper {
    User toEntity(AuthenticationRequest authenticationRequest);
    User toEntity(UserRequest userRequest);

}
