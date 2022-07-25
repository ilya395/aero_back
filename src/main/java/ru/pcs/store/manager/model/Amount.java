package ru.pcs.store.manager.model;

import lombok.*;
import ru.pcs.store.manager.enums.PaymentMethod;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "offersAmount")
public class Amount {

    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amountPart")
    private BigDecimal amountPart;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}
