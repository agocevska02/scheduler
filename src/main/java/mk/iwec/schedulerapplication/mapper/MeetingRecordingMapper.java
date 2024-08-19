package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.Group;
import mk.iwec.schedulerapplication.model.MeetingRecording;
import mk.iwec.schedulerapplication.model.dto.GroupDTO;
import mk.iwec.schedulerapplication.model.dto.MeetingRecordingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeetingRecordingMapper extends  GeneralMapper<MeetingRecordingDTO, MeetingRecording> {


    public MeetingRecordingDTO entityToDto(MeetingRecording entity);


    @Mapping(target = "uuid", ignore = true)
    public MeetingRecording dtoToEntity(MeetingRecordingDTO dto);
}
