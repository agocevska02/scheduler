package mk.iwec.schedulerapplication.mapper;

public interface GeneralMapper<Dto, Entity> {
    public Dto entityToDto(Entity entity);

    public Entity dtoToEntity(Dto dto);
}