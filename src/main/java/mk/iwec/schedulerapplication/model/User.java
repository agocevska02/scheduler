package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_app")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToOne()
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToMany()
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<UserRole> roles;

    @ManyToMany(mappedBy = "students")
    private List<Course> coursesAsStudent;

    @ManyToMany(mappedBy = "instructors")
    private List<Course> coursesAsInstructor;


}