package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
