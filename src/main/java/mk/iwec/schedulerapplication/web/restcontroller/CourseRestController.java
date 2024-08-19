package mk.iwec.schedulerapplication.web.restcontroller;

import mk.iwec.schedulerapplication.mapper.CourseMapper;
import mk.iwec.schedulerapplication.model.Course;
import mk.iwec.schedulerapplication.model.dto.CourseDTO;
import mk.iwec.schedulerapplication.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController {

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseService.getAll();
        return courses.stream()
                .map(courseMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable UUID id) {
        Optional<Course> course = courseService.getById(id);
        return course.map(courseMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.dtoToEntity(courseDTO);
        Course createdCourse = courseService.save(course);
        CourseDTO createdCourseDTO = courseMapper.entityToDto(createdCourse);
        return ResponseEntity.ok(createdCourseDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable UUID id, @RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.dtoToEntity(courseDTO);
        Optional<Course> updatedCourse = courseService.update(id, course);
        return updatedCourse.map(courseMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable UUID id) {
        boolean isDeleted = courseService.delete(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}