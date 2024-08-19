package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.User;
import mk.iwec.schedulerapplication.repository.UserRepository;
import mk.iwec.schedulerapplication.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements GenericService<User> {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public Optional<User> update(UUID id, User entity) {
        return getById(id).map(user1 -> {
            user1.setUsername(entity.getUsername());
            user1.setPassword(entity.getPassword());
            user1.setDate_created(entity.getDate_created());
            user1.setActive(entity.isActive());
            user1.setContact(entity.getContact());
            user1.setRoles(entity.getRoles());
            return userRepository.save(entity);
        });
    }

    @Override
    public boolean delete(UUID id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
