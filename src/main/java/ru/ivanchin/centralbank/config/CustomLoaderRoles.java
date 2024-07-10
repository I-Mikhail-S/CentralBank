package ru.ivanchin.centralbank.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.ivanchin.centralbank.repository.RoleRepository;
import ru.ivanchin.centralbank.user.Role;
import ru.ivanchin.centralbank.user.RoleEntity;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class CustomLoaderRoles {

    private final RoleRepository roleRepository;

    @Bean
    public void loaderRoles() {
        Arrays.stream(Role.values()).forEach(role -> {
            if (roleRepository.findRoleByName(role.name()).isEmpty()) {
                roleRepository.save(new RoleEntity(role));
            }
        } );
    }

}
