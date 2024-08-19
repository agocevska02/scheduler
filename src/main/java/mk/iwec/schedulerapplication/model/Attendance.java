package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

@Entity
@Data
@NoArgsConstructor
public class Attendance extends BaseEntity {

    private Boolean present;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    public Attendance(Boolean present, User user, Meeting meeting) {
        this.present = present;
        this.user = user;
        this.meeting = meeting;
    }
}