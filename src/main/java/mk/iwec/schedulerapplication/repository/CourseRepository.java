package mk.iwec.schedulerapplication.repository;

import mk.iwec.schedulerapplication.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
