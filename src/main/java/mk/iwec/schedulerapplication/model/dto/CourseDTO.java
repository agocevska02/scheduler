package mk.iwec.schedulerapplication.model.dto;


import java.time.LocalDate;
import java.util.List;

public class CourseDTO {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate finalDateToApply;
    private Integer durationInMonths;
    private Integer price;
    private String location;
    private Integer meetingsPerWeek;
    private Integer hoursPerMeeting;
    private String courseLevel;

    private List<UserDTO> studentsDTOs;
    private List<UserDTO> instructorsDTOs;
    private List<MeetingDTO> meetingsDTOs;
}
