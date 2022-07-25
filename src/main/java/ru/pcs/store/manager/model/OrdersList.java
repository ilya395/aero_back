package ru.pcs.store.manager.model;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "productsInOrder")
public class OrdersList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @ManyToMany
    private List<Product> productId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}
