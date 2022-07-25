package ru.pcs.store.manager.service;

import ru.pcs.store.manager.form.OrderForm;
import ru.pcs.store.manager.model.Order;

import java.util.List;

public interface OrderService {

    void create(OrderForm form);

    List<Order> readAll();

    Order read(Long id);

    void update(Long id, OrderForm form);

    void delete(Long id);

    void makeOrderStatusProcessing(Long id);

    void makeOrderStatusCollecting(Long id);

    void makeOrderStatusProofOfPayment(Long id);

    void makeOrderStatusShipped(Long id);
}
