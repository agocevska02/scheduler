package mk.iwec.schedulerapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.*;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {

    private String name;
    private String description;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "final_date_to_apply")
    private LocalDate finalDateToApply;
    @Column(name = "duration_in_months")
    private Integer durationInMonths;
    private Integer price;
    private String location;
    @Column(name = "meetings_per_week")
    private Integer meetingsPerWeek;
    @Column(name = "hours_per_meeting")
    private Integer hoursPerMeeting;
    @Column(name = "course_level")
    private String courseLevel;

    @ManyToMany
    @JoinTable(
            name = "r_course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> students;

    @ManyToMany
    @JoinTable(
            name = "r_course_instructor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> instructors;

    @OneToMany(mappedBy = "course")
    private List<Meeting> meetings;

    public Course(String name, String description, LocalDate startDate, LocalDate finalDateToApply, Integer durationInMonths, Integer price, String location, Integer meetingsPerWeek, Integer hoursPerMeeting, String courseLevel) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finalDateToApply = finalDateToApply;
        this.durationInMonths = durationInMonths;
        this.price = price;
        this.location = location;
        this.meetingsPerWeek = meetingsPerWeek;
        this.hoursPerMeeting = hoursPerMeeting;
        this.courseLevel = courseLevel;
    }
}
