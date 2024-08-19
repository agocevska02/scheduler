package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
    Optional<Image> findByName(String name);
}
