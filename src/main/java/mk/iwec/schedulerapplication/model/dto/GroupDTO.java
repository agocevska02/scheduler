package mk.iwec.schedulerapplication.model.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import mk.iwec.schedulerapplication.model.User;

import java.time.LocalDate;
import java.util.List;

public class GroupDTO {
    private String groupName;
    private LocalDate startDate;
    private LocalDate endDate;


    private List<UserDTO> participantsDTO;


    private List<UserDTO> instructorsDTO;
}
