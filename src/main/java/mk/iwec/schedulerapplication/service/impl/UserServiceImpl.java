package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.User;
import mk.iwec.schedulerapplication.repository.UserRepository;
import mk.iwec.schedulerapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User user) {
        return getUserById(id).map(user1 -> {
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            user1.setDate_created(user.getDate_created());
            user1.setActive(user.isActive());
            user1.setContact(user.getContact());
            user1.setRoles(user.getRoles());
            return userRepository.save(user);
        });
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
