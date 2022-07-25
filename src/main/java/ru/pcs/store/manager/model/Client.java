package ru.pcs.store.manager.model;

import lombok.*;
import ru.pcs.store.manager.enums.ClientStatus;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "clientStatus")
    @Enumerated(value = EnumType.STRING)
    private ClientStatus status;

    @OneToMany
    private List<Order> orders;
}
