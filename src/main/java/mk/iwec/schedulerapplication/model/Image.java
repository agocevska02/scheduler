package mk.iwec.schedulerapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseEntity {

    private  String type;
    private  String name;
    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

}
