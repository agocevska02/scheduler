package mk.iwec.schedulerapplication.web.restcontroller;

import mk.iwec.schedulerapplication.mapper.GroupMapper;
import mk.iwec.schedulerapplication.mapper.MeetingMapper;
import mk.iwec.schedulerapplication.model.Group;
import mk.iwec.schedulerapplication.model.Meeting;
import mk.iwec.schedulerapplication.model.dto.GroupDTO;
import mk.iwec.schedulerapplication.model.dto.MeetingDTO;
import mk.iwec.schedulerapplication.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/groups")
public class GroupRestController {

    @Autowired
    private GroupServiceImpl groupService;

    @Autowired
    private GroupMapper groupMapper;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        List<Group> groups = groupService.getAll();
        return groups.stream()
                .map(groupMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable UUID id) {
        Optional<Group> group = groupService.getById(id);
        return group.map(groupMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GroupDTO> createMeeting(@RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.dtoToEntity(groupDTO);
        Group createdGroup = groupService.save(group);
        GroupDTO creatingGroupDTO = groupMapper.entityToDto(createdGroup);
        return ResponseEntity.ok(creatingGroupDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GroupDTO> updateMeeting(@PathVariable UUID id, @RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.dtoToEntity(groupDTO);
        Optional<Group> updatedGroup = groupService.update(id, group);
        return updatedGroup.map(groupMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable UUID id) {
        boolean isDeleted = groupService.delete(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
