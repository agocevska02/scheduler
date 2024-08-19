package mk.iwec.schedulerapplication.model;


import jakarta.persistence.*;
import lombok.*;
import mk.iwec.schedulerapplication.infrastructure.pojo.BaseEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "user_role")
public class UserRole extends BaseEntity {

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
