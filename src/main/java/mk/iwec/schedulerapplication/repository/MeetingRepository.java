package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting,Long> {
}
