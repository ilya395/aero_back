package ru.pcs.store.manager.service.impl;

import ru.pcs.store.manager.enums.OrderStatus;
import ru.pcs.store.manager.form.OrderForm;
import ru.pcs.store.manager.model.Order;
import ru.pcs.store.manager.repositories.OrderRepository;
import ru.pcs.store.manager.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void create(OrderForm form) {
        Order order = Order.builder()
                .address(form.getAddress())
                .date(form.getDate())
                .price(form.getPrice())
                .status(OrderStatus.processing)
                .build();
        orderRepository.save(order);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order read(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public void update(Long id, OrderForm form) {
        Order order = orderRepository.getById(id);
        order.setAddress(form.getAddress());
        order.setDate(form.getDate());
        order.setPrice(form.getPrice());
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void makeOrderStatusProcessing(Long id) {
        Order order = orderRepository.getById(id);
        order.setStatus(OrderStatus.processing);
        orderRepository.save(order);
    }

    @Override
    public void makeOrderStatusCollecting(Long id) {
        Order order = orderRepository.getById(id);
        order.setStatus(OrderStatus.collecting);
        orderRepository.save(order);
    }

    @Override
    public void makeOrderStatusProofOfPayment(Long id) {
        Order order = orderRepository.getById(id);
        order.setStatus(OrderStatus.proofOfPayment);
        orderRepository.save(order);
    }

    @Override
    public void makeOrderStatusShipped(Long id) {
        Order order = orderRepository.getById(id);
        order.setStatus(OrderStatus.shipped);
        orderRepository.save(order);
    }
}
