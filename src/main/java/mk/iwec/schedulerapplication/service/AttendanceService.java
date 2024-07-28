package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.Attendance;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    List<Attendance> getAllAttendances();
    Optional<Attendance> getAttendanceById(Long id);
    Attendance saveAttendance(Attendance attendance);
    Optional<Attendance> updateAttendance(Long id,Attendance attendance);
    boolean deleteAttendance(Long id);
}
