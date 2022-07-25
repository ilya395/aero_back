package ru.storemanager.manager.services.ordersgroup;

import ru.storemanager.manager.enums.PaymentMethod;
import ru.storemanager.manager.models.order.Order;
import ru.storemanager.manager.models.ordersgroup.OrdersGroup;

import java.math.BigDecimal;
import java.util.List;

public interface OrdersGroupsService {

    void checkout(List<Order> orders,
                  String address,
                  PaymentMethod paymentMethod,
                  BigDecimal totalPrice);

    List<OrdersGroup> getByUserName(String email);

    List<OrdersGroup> findAll();

    OrdersGroup getById(Long id);

    void changeStatusById(Long id, String status);
}
