package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.*;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

import java.awt.*;

@EqualsAndHashCode(callSuper = true) //da prasama za ova
@Entity
@Data
@NoArgsConstructor
public class Contact extends BaseEntity {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Image avatar;

    public Contact(String firstname, String lastname, String email, String phonenumber, String address, Image avatar) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.address = address;
        this.avatar=avatar;
    }
}
