package mk.iwec.schedulerapplication.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ImageDTO {
    private  String type;
    private  String name;
    private byte[] imageData;
}
