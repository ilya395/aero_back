package ru.storemanager.manager.models.order;

import lombok.Builder;
import ru.storemanager.manager.models.ordersgroup.OrdersGroup;
import ru.storemanager.manager.models.product.Product;
import ru.storemanager.manager.models.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Builder
@Entity
@Table(name = "booking")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private OrdersGroup ordersGroup;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order(Long id, Integer count, OrdersGroup ordersGroup, User user, Product product) {
        this.id = id;
        this.count = count;
        this.ordersGroup = ordersGroup;
        this.user = user;
        this.product = product;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public OrdersGroup getOrdersGroup() {
        return ordersGroup;
    }

    public void setOrdersGroup(OrdersGroup ordersGroup) {
        this.ordersGroup = ordersGroup;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(count, order.count) && Objects.equals(ordersGroup, order.ordersGroup) && Objects.equals(user, order.user) && Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
