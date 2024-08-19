package mk.iwec.schedulerapplication.service.impl;

import mk.iwec.schedulerapplication.model.Group;
import mk.iwec.schedulerapplication.repository.GroupRepository;
import mk.iwec.schedulerapplication.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class GroupServiceImpl implements GenericService<Group> {
    @Autowired
    private GroupRepository groupRepository;
    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> getById(UUID id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group save(Group entity) {
        return groupRepository.save(entity);
    }

    @Override
    public Optional<Group> update(UUID id, Group entity) {
        return getById(id).map(group -> {
           group.setGroupName(entity.getGroupName());
           group.setStartDate(entity.getStartDate());
           group.setInstructors(entity.getInstructors());
           group.setParticipants(entity.getParticipants());
           group.setEndDate(entity.getEndDate());
            return groupRepository.save(group);
        });
    }

    @Override
    public boolean delete(UUID id) {
        return groupRepository.findById(id).map(group -> {
            groupRepository.delete(group);
            return true;
        }).orElse(false);
    }
}
