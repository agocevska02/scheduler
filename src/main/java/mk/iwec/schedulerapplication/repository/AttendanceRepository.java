package mk.iwec.schedulerapplication.repository;


import mk.iwec.schedulerapplication.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {
}
