package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
