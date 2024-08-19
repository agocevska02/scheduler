package mk.iwec.schedulerapplication.mapper;

import mk.iwec.schedulerapplication.model.Contact;
import mk.iwec.schedulerapplication.model.Course;
import mk.iwec.schedulerapplication.model.dto.ContactDTO;
import mk.iwec.schedulerapplication.model.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper extends  GeneralMapper<CourseDTO, Course> {


    public CourseDTO entityToDto(Course entity);


    @Mapping(target = "uuid", ignore = true)
    public Course dtoToEntity(CourseDTO dto);
}