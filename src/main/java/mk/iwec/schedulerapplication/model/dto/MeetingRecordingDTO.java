package mk.iwec.schedulerapplication.model.dto;

import lombok.Data;

@Data
public class MeetingRecordingDTO {
    private String name;
    private String type;

    private byte[] recordingData;
}
