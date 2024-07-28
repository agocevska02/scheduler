package mk.iwec.schedulerapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String duration;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> students;

    @ManyToMany
    @JoinTable(
            name = "course_instructor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> instructors;

    @OneToMany(mappedBy = "course")
    private List<Meeting> meetings;

    public Course(String name, String description, String duration, List<User> students, List<User> instructors, List<Meeting> meetings) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.students = students;
        this.instructors = instructors;
        this.meetings = meetings;
    }

    public Course(String name, String description, String duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }
}
