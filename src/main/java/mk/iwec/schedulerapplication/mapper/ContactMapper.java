package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.Contact;
import mk.iwec.schedulerapplication.model.User;
import mk.iwec.schedulerapplication.model.UserRole;
import mk.iwec.schedulerapplication.model.dto.ContactDTO;
import mk.iwec.schedulerapplication.model.dto.UserRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper extends  GeneralMapper<ContactDTO, Contact> {


    public ContactDTO entityToDto(Contact entity);


    @Mapping(target = "uuid", ignore = true)
    public Contact dtoToEntity(ContactDTO dto);
}

