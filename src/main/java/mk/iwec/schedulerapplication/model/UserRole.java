package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public UserRole(String role) {
        this.role = role;
    }

    public UserRole(String role, List<User> users) {
        this.role = role;
        this.users = users;
    }
}
