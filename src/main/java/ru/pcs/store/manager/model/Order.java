package ru.pcs.store.manager.model;

import lombok.*;
import ru.pcs.store.manager.enums.OrderStatus;
import ru.pcs.store.manager.enums.PaymentMethod;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Column(name = "orderStatus")
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "orderCreateDate")
    private LocalDate orderCreateDate = LocalDate.now();

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "toPaySum")
    private BigDecimal toPaySum;

    @Column(name = "payed")
    private BigDecimal payed;

    @Column(name = "paymentMethod")
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany
    private List<OrdersList> productsInOrder;

//    @OneToMany
//    private List<Amount> amountList;
}
