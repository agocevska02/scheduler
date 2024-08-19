package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.Image;
import mk.iwec.schedulerapplication.model.Meeting;
import mk.iwec.schedulerapplication.model.dto.ImageDTO;
import mk.iwec.schedulerapplication.model.dto.MeetingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper extends  GeneralMapper<ImageDTO, Image> {


    public ImageDTO entityToDto(Image entity);


    @Mapping(target = "uuid", ignore = true)
    public Image dtoToEntity(ImageDTO dto);
}
