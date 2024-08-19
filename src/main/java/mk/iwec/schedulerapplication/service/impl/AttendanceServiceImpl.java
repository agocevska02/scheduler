package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.Attendance;
import mk.iwec.schedulerapplication.repository.AttendanceRepository;
import mk.iwec.schedulerapplication.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttendanceServiceImpl implements GenericService<Attendance> {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Optional<Attendance> getById(UUID id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public Attendance save(Attendance entity) {
        return attendanceRepository.save(entity);
    }

    @Override
    public Optional<Attendance> update(UUID id, Attendance entity) {
        return getById(id).map(existingAttendance -> {
            existingAttendance.setPresent(entity.getPresent());
            existingAttendance.setMeeting(entity.getMeeting());
            existingAttendance.setUser(entity.getUser());

            return attendanceRepository.save(existingAttendance);
        });
    }

    @Override
    public boolean delete(UUID id) {
        return getById(id).map(attendance -> {
            attendanceRepository.delete(attendance);
            return true;
        }).orElse(false);
    }
}
