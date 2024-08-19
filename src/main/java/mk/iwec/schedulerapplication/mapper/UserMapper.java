package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.User;
import mk.iwec.schedulerapplication.model.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends  GeneralMapper<UserDTO, User> {


    public UserDTO entityToDto(User entity);


    @Mapping(target = "uuid", ignore = true)
    public User dtoToEntity(UserDTO dto);
}
