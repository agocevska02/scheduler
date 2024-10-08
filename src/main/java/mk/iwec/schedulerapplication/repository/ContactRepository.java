package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
