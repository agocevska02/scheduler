package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
