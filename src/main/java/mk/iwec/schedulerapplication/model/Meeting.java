package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "meeting")
    private List<Attendance> attendances;

    public Meeting(String topic, LocalTime startTime, LocalTime endTime, LocalDate date, Course course, List<Attendance> attendances) {
        this.topic = topic;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.course = course;
        this.attendances = attendances;
    }

    public Meeting(String topic, LocalTime startTime, LocalTime endTime, LocalDate date, Course course) {
        this.topic = topic;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.course = course;
    }
}
