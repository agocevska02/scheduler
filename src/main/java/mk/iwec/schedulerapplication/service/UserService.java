package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    Optional<User> updateUser(Long id,User user);
    boolean deleteUser(Long id);
}
