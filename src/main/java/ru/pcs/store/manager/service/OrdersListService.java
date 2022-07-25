package ru.pcs.store.manager.service;

import ru.pcs.store.manager.form.OrdersListForm;
import ru.pcs.store.manager.model.OrdersList;

import java.util.List;

public interface OrdersListService {

    void create(OrdersListForm form);

    List<OrdersList> readAll();

    OrdersList read(Long id);

    void update(Long id, OrdersListForm form);

    void delete(Long id);
}
