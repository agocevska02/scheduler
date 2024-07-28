package mk.iwec.schedulerapplication.service.impl;


import jakarta.persistence.EntityNotFoundException;
import mk.iwec.schedulerapplication.model.Attendance;
import mk.iwec.schedulerapplication.repository.AttendanceRepository;
import mk.iwec.schedulerapplication.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {

        return attendanceRepository.save(attendance);
    }

    @Override
    public Optional<Attendance> updateAttendance(Long id, Attendance attendance) {
        return getAttendanceById(id).map(existingAttendance -> {
            existingAttendance.setPresent(attendance.getPresent());
            existingAttendance.setMeeting(attendance.getMeeting());
            existingAttendance.setUser(attendance.getUser());

            return attendanceRepository.save(existingAttendance);
        });
    }

    @Override
    public boolean deleteAttendance(Long id) {
        return getAttendanceById(id).map(attendance -> {
            attendanceRepository.delete(attendance);
            return true;
        }).orElse(false);
    }
}
