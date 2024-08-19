package mk.iwec.schedulerapplication.web.restcontroller;

import mk.iwec.schedulerapplication.mapper.AttendanceMapper;
import mk.iwec.schedulerapplication.model.Attendance;
import mk.iwec.schedulerapplication.model.dto.AttendanceDTO;
import mk.iwec.schedulerapplication.service.impl.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceRestController {

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @Autowired
    private AttendanceMapper attendanceMapper;

    @GetMapping
    public List<AttendanceDTO> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAll();
        return attendances.stream()
                .map(attendanceMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceDTO> getAttendanceById(@PathVariable UUID id) {
        Optional<Attendance> attendance = attendanceService.getById(id);
        return attendance.map(attendanceMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AttendanceDTO> createAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        Attendance attendance = attendanceMapper.dtoToEntity(attendanceDTO);
        Attendance createdAttendance = attendanceService.save(attendance);
        AttendanceDTO createdAttendanceDTO = attendanceMapper.entityToDto(createdAttendance);
        return ResponseEntity.ok(createdAttendanceDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AttendanceDTO> updateAttendance(@PathVariable UUID id, @RequestBody AttendanceDTO attendanceDTO) {
        Attendance attendance = attendanceMapper.dtoToEntity(attendanceDTO);
        Optional<Attendance> updatedAttendance = attendanceService.update(id, attendance);
        return updatedAttendance.map(attendanceMapper::entityToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable UUID id) {
        boolean isDeleted = attendanceService.delete(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
