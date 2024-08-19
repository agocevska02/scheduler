package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.Contact;
import mk.iwec.schedulerapplication.model.Meeting;
import mk.iwec.schedulerapplication.model.dto.ContactDTO;
import mk.iwec.schedulerapplication.model.dto.MeetingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeetingMapper extends  GeneralMapper<MeetingDTO, Meeting> {


    public MeetingDTO entityToDto(Meeting entity);


    @Mapping(target = "uuid", ignore = true)
    public Meeting dtoToEntity(MeetingDTO dto);
}
