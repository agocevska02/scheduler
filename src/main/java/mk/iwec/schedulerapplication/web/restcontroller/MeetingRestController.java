package mk.iwec.schedulerapplication.web.restcontroller;

import mk.iwec.schedulerapplication.mapper.MeetingMapper;
import mk.iwec.schedulerapplication.model.Meeting;
import mk.iwec.schedulerapplication.model.dto.MeetingDTO;
import mk.iwec.schedulerapplication.service.impl.MeetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/meetings")
public class MeetingRestController {

    @Autowired
    private MeetingServiceImpl meetingService;

    @Autowired
    private MeetingMapper meetingMapper;

    @GetMapping
    public List<MeetingDTO> getAllMeetings() {
        List<Meeting> meetings = meetingService.getAll();
        return meetings.stream()
                .map(meetingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDTO> getMeetingById(@PathVariable UUID id) {
        Optional<Meeting> meeting = meetingService.getById(id);
        return meeting.map(meetingMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MeetingDTO> createMeeting(@RequestBody MeetingDTO meetingDTO) {
        Meeting meeting = meetingMapper.dtoToEntity(meetingDTO);
        Meeting createdMeeting = meetingService.save(meeting);
        MeetingDTO createdMeetingDTO = meetingMapper.entityToDto(createdMeeting);
        return ResponseEntity.ok(createdMeetingDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MeetingDTO> updateMeeting(@PathVariable UUID id, @RequestBody MeetingDTO meetingDTO) {
        Meeting meeting = meetingMapper.dtoToEntity(meetingDTO);
        Optional<Meeting> updatedMeeting = meetingService.update(id, meeting);
        return updatedMeeting.map(meetingMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable UUID id) {
        boolean isDeleted = meetingService.delete(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
