package mk.iwec.schedulerapplication.web.restcontroller;


import mk.iwec.schedulerapplication.model.UserRole;
import mk.iwec.schedulerapplication.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleRestController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAllRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getRoleById(@PathVariable Long id) {
        Optional<UserRole> role = userRoleService.getUserRolesById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserRole> createRole(@RequestBody UserRole role) {
        UserRole createdRole = userRoleService.saveUserRole(role);
        return ResponseEntity.ok(createdRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateRole(@PathVariable Long id, @RequestBody UserRole roleDetails) {
        Optional<UserRole> updatedRole = userRoleService.updateUserRole(id, roleDetails);
        return updatedRole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        boolean isDeleted = userRoleService.deleteUserRole(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

