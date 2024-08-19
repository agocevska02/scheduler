package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.User;
import mk.iwec.schedulerapplication.model.UserRole;
import mk.iwec.schedulerapplication.model.dto.UserDTO;
import mk.iwec.schedulerapplication.model.dto.UserRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper extends  GeneralMapper<UserRoleDTO, UserRole> {


    public UserRoleDTO entityToDto(UserRole entity);


    @Mapping(target = "uuid", ignore = true)
    public UserRole dtoToEntity(UserRoleDTO dto);
}
