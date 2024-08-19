package mk.iwec.schedulerapplication.service.impl;


import mk.iwec.schedulerapplication.model.Meeting;
import mk.iwec.schedulerapplication.repository.MeetingRepository;
import mk.iwec.schedulerapplication.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeetingServiceImpl implements GenericService<Meeting> {

    @Autowired
    private MeetingRepository meetingRepository;


    @Override
    public List<Meeting> getAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Optional<Meeting> getById(UUID id) {
        return meetingRepository.findById(id);
    }

    @Override
    public Meeting save(Meeting entity) {
        return meetingRepository.save(entity);
    }

    @Override
    public Optional<Meeting> update(UUID id, Meeting entity) {
        return getById(id).map(existingMeeting -> {

            existingMeeting.setDate(entity.getDate());
            existingMeeting.setStartTime(entity.getStartTime());
            existingMeeting.setEndTime(entity.getEndTime());
            existingMeeting.setTopic(entity.getTopic());
            existingMeeting.setCourse(entity.getCourse());
            existingMeeting.setAttendances(entity.getAttendances());
            existingMeeting.setMeetingRecording(entity.getMeetingRecording());
            existingMeeting.setGroup(entity.getGroup());
            existingMeeting.setZoomMeetLink(entity.getZoomMeetLink());
            return meetingRepository.save(existingMeeting);
        });
    }

    @Override
    public boolean delete(UUID id) {
        return getById(id).map(meeting->{
            meetingRepository.delete(meeting);
            return true;
        }).orElse(false);
    }
}

