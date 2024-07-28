package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.UserRole;
import mk.iwec.schedulerapplication.repository.UserRoleRepository;
import mk.iwec.schedulerapplication.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> getUserRolesById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public Optional<UserRole> updateUserRole(Long id, UserRole userRole) {
        return userRoleRepository.findById(id).map(role -> {
            role.setRole(userRole.getRole());
            return userRoleRepository.save(role);
        });
    }

    @Override
    public boolean deleteUserRole(Long id) {
        return userRoleRepository.findById(id).map(role -> {
            userRoleRepository.delete(role);
            return true;
        }).orElse(false);
    }
}
