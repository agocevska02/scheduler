package mk.iwec.schedulerapplication.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import mk.iwec.schedulerapplication.model.Contact;
import mk.iwec.schedulerapplication.model.UserRole;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDTO {
    private String username;
    private String password;
    private LocalDate date_created;
    private boolean isActive;
    private ContactDTO contactDTO;
    private List<UserRoleDTO> userRoleDTOS;

}
