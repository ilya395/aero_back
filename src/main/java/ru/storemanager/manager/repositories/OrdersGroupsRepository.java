package ru.storemanager.manager.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.storemanager.manager.models.ordersgroup.OrdersGroup;
import ru.storemanager.manager.models.user.User;

import java.util.Date;
import java.util.List;

public interface OrdersGroupsRepository extends JpaRepository<OrdersGroup, Long> {

    OrdersGroup findOrdersGroupByDate(Date date);

    List<OrdersGroup> findAllByUser(User user);

    OrdersGroup getById(Long id);
}
