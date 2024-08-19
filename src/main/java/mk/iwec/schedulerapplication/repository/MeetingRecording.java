package mk.iwec.schedulerapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeetingRecording extends JpaRepository<MeetingRecording, UUID> {
}
