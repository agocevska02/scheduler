package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.Attendance;
import mk.iwec.schedulerapplication.model.Group;
import mk.iwec.schedulerapplication.model.dto.AttendanceDTO;
import mk.iwec.schedulerapplication.model.dto.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttendanceMapper extends  GeneralMapper<AttendanceDTO, Attendance> {


    public AttendanceDTO entityToDto(Attendance entity);


    @Mapping(target = "uuid", ignore = true)
    public Attendance dtoToEntity(AttendanceDTO dto);
}
