package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.Course;
import mk.iwec.schedulerapplication.repository.CourseRepository;
import mk.iwec.schedulerapplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(Course course) {

        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> updateCourse(Long id, Course course) {
        return getCourseById(id).map(course1 -> {
            course1.setDescription(course.getDescription());
            course1.setName(course.getName());

            course1.setStudents(course.getStudents());
            course1.setInstructors(course.getInstructors());
            course1.setMeetings(course.getMeetings());

            course1.setDuration(course.getDuration());

            return courseRepository.save(course1);
        });
    }

    @Override
    public boolean deleteCourse(Long id) {
        return getCourseById(id).map(course -> {
            courseRepository.delete(course);
            return true;
        }).orElse(false);
    }
}
