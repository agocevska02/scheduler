package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course saveCourse(Course course);
    Optional<Course> updateCourse(Long id,Course course);
    boolean deleteCourse(Long id);
}
