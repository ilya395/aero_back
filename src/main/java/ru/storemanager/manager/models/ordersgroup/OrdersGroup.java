package ru.storemanager.manager.models.ordersgroup;

import lombok.Builder;
import ru.storemanager.manager.enums.PaymentMethod;
import ru.storemanager.manager.enums.Status;
import ru.storemanager.manager.models.user.User;
import ru.storemanager.manager.models.order.Order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "group_booking")
public class OrdersGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "paymentMethod")
    private PaymentMethod paymentMethod;

    @Column(name = "status")
    private Status status;

    @OneToMany
    private List<Order> orders;

    @Column(name = "date")
    private Date date;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;
    public OrdersGroup(Long id, String address, PaymentMethod paymentMethod, Status status, List<Order> orders, Date date, BigDecimal totalPrice, User user) {
        this.id = id;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.orders = orders;
        this.date = date;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public OrdersGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersGroup that = (OrdersGroup) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && paymentMethod == that.paymentMethod && status == that.status && Objects.equals(orders, that.orders) && Objects.equals(date, that.date) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
