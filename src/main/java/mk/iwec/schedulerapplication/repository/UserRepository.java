package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
