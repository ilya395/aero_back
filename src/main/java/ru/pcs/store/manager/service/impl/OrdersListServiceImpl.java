package ru.pcs.store.manager.service.impl;

import ru.pcs.store.manager.form.OrdersListForm;
import ru.pcs.store.manager.model.OrdersList;
import ru.pcs.store.manager.repositories.OrdersListRepository;
import ru.pcs.store.manager.service.OrdersListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersListServiceImpl implements OrdersListService {

    private final OrdersListRepository ordersListRepository;

    @Override
    public void create(OrdersListForm form) {
        OrdersList ordersList = OrdersList.builder()
                .number(form.getNumber())
                .build();
        ordersListRepository.save(ordersList);
    }

    @Override
    public List<OrdersList> readAll() {
        return ordersListRepository.findAll();
    }

    @Override
    public OrdersList read(Long id) {
        return ordersListRepository.getById(id);
    }

    //todo
    @Override
    public void update(Long id, OrdersListForm form) {
        OrdersList list = ordersListRepository.getById(id);
        list.setNumber(form.getNumber());
        ordersListRepository.save(list);
    }

    @Override
    public void delete(Long id) {
        ordersListRepository.deleteById(id);
    }
}
