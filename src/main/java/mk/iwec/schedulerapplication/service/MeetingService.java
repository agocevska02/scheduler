package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.Meeting;

import java.util.List;
import java.util.Optional;

public interface MeetingService {
    List<Meeting> getAllMeetings();
    Optional<Meeting> getMeetingById(Long id);
    Meeting saveMeeting(Meeting meeting);
    Optional<Meeting> updateMeeting(Long id,Meeting meeting);
    boolean deleteMeeting(Long id);
}
