package mk.iwec.schedulerapplication.web.restcontroller;

import mk.iwec.schedulerapplication.mapper.UserRoleMapper;
import mk.iwec.schedulerapplication.model.User;
import mk.iwec.schedulerapplication.model.UserRole;
import mk.iwec.schedulerapplication.model.dto.UserRoleDTO;
import mk.iwec.schedulerapplication.service.impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleRestController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @GetMapping
    public List<UserRoleDTO> getAllRoles() {
        List<UserRole> roles = userRoleService.getAll();
        return roles.stream()
                .map(userRoleMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getRoleById(@PathVariable UUID id) {
        Optional<UserRole> role = userRoleService.getById(id);
        return role.map(userRoleMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserRoleDTO> createRole(@RequestBody UserRoleDTO roleDTO) {
        UserRole role = userRoleMapper.dtoToEntity(roleDTO);
        UserRole createdRole = userRoleService.save(role);
        UserRoleDTO createdRoleDTO = userRoleMapper.entityToDto(createdRole);
        return ResponseEntity.ok(createdRoleDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserRoleDTO> updateRole(@PathVariable UUID id, @RequestBody UserRoleDTO roleDTO) {
        UserRole role =userRoleMapper.dtoToEntity(roleDTO);
        Optional<UserRole> updatedRole = userRoleService.update(id, role);
        return updatedRole.map(userRoleMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
        boolean isDeleted = userRoleService.delete(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
