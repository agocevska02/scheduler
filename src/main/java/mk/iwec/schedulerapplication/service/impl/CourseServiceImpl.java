package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.Course;
import mk.iwec.schedulerapplication.repository.CourseRepository;
import mk.iwec.schedulerapplication.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements GenericService<Course> {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getById(UUID id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    public Optional<Course> update(UUID id, Course entity) {
        return getById(id).map(course1 -> {
            course1.setDescription(entity.getDescription());
            course1.setName(entity.getName());
            course1.setStudents(entity.getStudents());
            course1.setInstructors(entity.getInstructors());
            course1.setMeetings(entity.getMeetings());
            course1.setCourseLevel(entity.getCourseLevel());
            course1.setDescription(entity.getDescription());
            course1.setDurationInMonths(entity.getDurationInMonths());
            course1.setFinalDateToApply(entity.getFinalDateToApply());
            course1.setHoursPerMeeting(entity.getHoursPerMeeting());
            course1.setMeetingsPerWeek(entity.getMeetingsPerWeek());
            course1.setPrice(entity.getPrice());
            course1.setLocation(entity.getLocation());
            course1.setStartDate(entity.getStartDate());

            return courseRepository.save(course1);
        });
    }

    @Override
    public boolean delete(UUID id) {
        return getById(id).map(course -> {
            courseRepository.delete(course);
            return true;
        }).orElse(false);
    }
}
