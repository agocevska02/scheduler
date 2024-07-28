package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.Meeting;
import mk.iwec.schedulerapplication.repository.MeetingRepository;
import mk.iwec.schedulerapplication.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Optional<Meeting> getMeetingById(Long id) {
        return meetingRepository.findById(id);
    }

    @Override
    public Meeting saveMeeting(Meeting meeting) {

        return meetingRepository.save(meeting);
    }






    @Override
    public Optional<Meeting> updateMeeting(Long id, Meeting meeting) {
        return getMeetingById(id).map(existingMeeting -> {

            existingMeeting.setDate(meeting.getDate());
            existingMeeting.setStartTime(meeting.getStartTime());
            existingMeeting.setEndTime(meeting.getEndTime());
            existingMeeting.setTopic(meeting.getTopic());
            existingMeeting.setCourse(meeting.getCourse());
            existingMeeting.setAttendances(meeting.getAttendances());
            return meetingRepository.save(existingMeeting);
        });
    }

    @Override
    public boolean deleteMeeting(Long id) {
        return getMeetingById(id).map(meeting->{
            meetingRepository.delete(meeting);
            return true;
        }).orElse(false);
    }
}

