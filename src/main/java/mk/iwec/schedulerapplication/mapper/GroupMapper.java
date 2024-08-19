package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.Group;
import mk.iwec.schedulerapplication.model.Meeting;
import mk.iwec.schedulerapplication.model.dto.GroupDTO;
import mk.iwec.schedulerapplication.model.dto.MeetingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper extends  GeneralMapper<GroupDTO, Group> {


    public GroupDTO entityToDto(Group entity);


    @Mapping(target = "uuid", ignore = true)
    public Group dtoToEntity(GroupDTO dto);
}
