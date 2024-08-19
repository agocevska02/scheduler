package mk.iwec.schedulerapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Group extends BaseEntity {

    @Column(name = "group_name")
    private String groupName;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @ManyToMany
    @JoinTable( name = "r_group_participants",
    joinColumns = @JoinColumn(name = "group_id"),
    inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private List<User> participants;

    @ManyToMany
    @JoinTable( name = "r_group_instructors",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<User> instructors;





}
