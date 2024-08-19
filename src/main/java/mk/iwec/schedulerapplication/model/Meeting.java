package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.*;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meeting extends BaseEntity {

    private String topic;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    private LocalDate date;
    @Column(name = "zoom_meet_link")
    private String zoomMeetLink;
    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "meeting_record_id")
    private MeetingRecording meetingRecording;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "meeting")
    private List<Attendance> attendances;

    public Meeting(String topic, LocalTime startTime, LocalTime endTime, LocalDate date, String zoomMeetLink) {
        this.topic = topic;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.zoomMeetLink = zoomMeetLink;
    }
}
