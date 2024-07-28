package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    List<UserRole> getAllUserRoles();
    Optional<UserRole> getUserRolesById(Long id);
    UserRole saveUserRole(UserRole userRole);
    Optional<UserRole> updateUserRole(Long id,UserRole userRole);
    boolean deleteUserRole(Long id);
}
