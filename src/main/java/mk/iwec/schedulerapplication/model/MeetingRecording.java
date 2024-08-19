package mk.iwec.schedulerapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class MeetingRecording extends BaseEntity {

    private String name;
    private String type;

    @Lob
    @Column(name = "recording_data")
    private byte[] recordingData;


}