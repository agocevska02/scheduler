package mk.iwec.schedulerapplication.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import mk.iwec.schedulerapplication.model.Attendance;
import mk.iwec.schedulerapplication.model.Course;
import mk.iwec.schedulerapplication.model.Group;
import mk.iwec.schedulerapplication.model.MeetingRecording;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class MeetingDTO {
    private String topic;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private String zoomMeetLink;
    private MeetingRecordingDTO meetingRecordingDTO;

    private GroupDTO groupDTO;


    private CourseDTO courseDTO;


    private List<AttendanceDTO> attendanceDTOS;

}
