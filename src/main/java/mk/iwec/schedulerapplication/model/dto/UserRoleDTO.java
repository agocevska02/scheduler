package mk.iwec.schedulerapplication.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRoleDTO {
    private String role;
    List<UserDTO> userDTOList;
}
