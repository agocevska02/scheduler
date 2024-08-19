package mk.iwec.schedulerapplication.model.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import mk.iwec.schedulerapplication.model.Image;

@Data
public class ContactDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;
    private ImageDTO avatar;

}
