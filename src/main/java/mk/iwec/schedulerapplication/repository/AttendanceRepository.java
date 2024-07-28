package mk.iwec.schedulerapplication.repository;


import mk.iwec.schedulerapplication.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
}
