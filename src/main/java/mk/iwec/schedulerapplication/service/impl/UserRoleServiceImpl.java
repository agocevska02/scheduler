package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.UserRole;
import mk.iwec.schedulerapplication.repository.UserRoleRepository;
import mk.iwec.schedulerapplication.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRoleServiceImpl implements GenericService<UserRole> {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> getById(UUID id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public UserRole save(UserRole entity) {
        return userRoleRepository.save(entity);
    }

    @Override
    public Optional<UserRole> update(UUID id, UserRole entity) {
        return userRoleRepository.findById(id).map(role -> {
            role.setRole(entity.getRole());
            return userRoleRepository.save(role);
        });
    }

    @Override
    public boolean delete(UUID id) {
        return userRoleRepository.findById(id).map(role -> {
            userRoleRepository.delete(role);
            return true;
        }).orElse(false);
    }
}
