package ru.storemanager.manager.services.order;

import ru.storemanager.manager.models.order.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrdersService {

    void addProductToKart(Long productId, String email, Integer count);

    List<Order> getCartList(String email);

    void deleteById(Long orderId);

    void increaseDecreaseCountById(Long orderId, int count);

    BigDecimal getTotalPrice(List<Order> orders);

    List<Order> getOrdersByOrdersGroupId(Long ordersGroupId);
}
