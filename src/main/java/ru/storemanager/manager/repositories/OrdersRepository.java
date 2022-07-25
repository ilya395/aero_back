package ru.storemanager.manager.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.storemanager.manager.models.ordersgroup.OrdersGroup;
import ru.storemanager.manager.models.order.Order;
import ru.storemanager.manager.models.product.Product;
import ru.storemanager.manager.models.user.User;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderByProductAndUser(Product product, User user);

    Optional<Order> findOrderByProductAndUserAndOrdersGroup(Product product, User user, OrdersGroup ordersGroup);

    Optional<List<Order>> findOrderByUserAndOrdersGroupOrderByIdDesc(User user, OrdersGroup ordersGroup);

    List<Order> getByOrdersGroupId(Long id, Sort sort);
}
