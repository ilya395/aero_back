package ru.pcs.store.manager.model;

import lombok.*;
import ru.pcs.store.manager.enums.Role;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId().equals(users.getId()) && getName().equals(users.getName()) && getPhone().equals(users.getPhone()) && Objects.equals(getEmail(), users.getEmail()) && getRole() == users.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhone(), getEmail(), getRole());
    }
}
