package mk.iwec.schedulerapplication.model.dto;

import lombok.Data;

@Data
public class AttendanceDTO {
    private Boolean present;
    private MeetingDTO meetingDTO;
    private UserDTO userDTO;
}
