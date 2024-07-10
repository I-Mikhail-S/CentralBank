package ru.ivanchin.centralbank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivanchin.centralbank.exception.RoleNotFoundException;
import ru.ivanchin.centralbank.repository.RoleRepository;
import ru.ivanchin.centralbank.user.Role;
import ru.ivanchin.centralbank.user.RoleEntity;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role finedRoleByName(String name) throws RoleNotFoundException {
        RoleEntity roleEntity = roleRepository.findRoleByName(name).orElseThrow(RoleNotFoundException::new);
        return Role.valueOf(roleEntity.getName());
    }

}
