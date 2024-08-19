package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.*;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {

    private String username;
    private String password;
    private LocalDate date_created;
    private boolean isActive;

    public User(String username, String password, LocalDate date_created, boolean isActive) {
        this.username = username;
        this.password = password;
        this.date_created = date_created;
        this.isActive = isActive;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "r_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserRole> roles;

}