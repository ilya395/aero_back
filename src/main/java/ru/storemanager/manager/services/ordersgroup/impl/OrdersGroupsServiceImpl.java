package ru.storemanager.manager.services.ordersgroup.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.storemanager.manager.enums.PaymentMethod;
import ru.storemanager.manager.enums.Status;
import ru.storemanager.manager.models.order.Order;
import ru.storemanager.manager.models.ordersgroup.OrdersGroup;
import ru.storemanager.manager.models.user.User;
import ru.storemanager.manager.repositories.OrdersGroupsRepository;
import ru.storemanager.manager.repositories.OrdersRepository;
import ru.storemanager.manager.repositories.UsersRepository;
import ru.storemanager.manager.services.ordersgroup.OrdersGroupsService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersGroupsServiceImpl implements OrdersGroupsService {

    private final OrdersGroupsRepository ordersGroupsRepository;
    private final OrdersRepository ordersRepository;
    private final UsersRepository usersRepository;

    @Override
    public void checkout(List<Order> orders,
                         String address,
                         PaymentMethod paymentMethod,
                         BigDecimal totalPrice) {
        if (orders.isEmpty()){
        }else{
            Date date = new Date(System.currentTimeMillis());
            Iterator iterator = orders.iterator();
            Order order = (Order) iterator.next();
            OrdersGroup ordersGroup = OrdersGroup.builder()
                    .paymentMethod(paymentMethod)
                    .status(Status.processing)
                    .address(address)
                    .date(date)
                    .totalPrice(totalPrice)
                    .user(order.getUser())
                    .build();
            ordersGroupsRepository.save(ordersGroup);
            OrdersGroup currentOrdersGroup = ordersGroupsRepository.findOrdersGroupByDate(date);
            iterator = orders.iterator();
            while (iterator.hasNext()){
                order = (Order) iterator.next();
                order.setOrdersGroup(currentOrdersGroup);
                ordersRepository.save(order);
            }
        }
    }

    @Override
    public List<OrdersGroup> getByUserName(String email) {
        User user = usersRepository.getByEmail(email);
        return ordersGroupsRepository.findAllByUser(user);
    }

    @Override
    public List<OrdersGroup> findAll() {
        return ordersGroupsRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    @Override
    public OrdersGroup getById(Long id) {
        return ordersGroupsRepository.getById(id);
    }

    @Override
    public void changeStatusById(Long id, String status) {
        OrdersGroup ordersGroup= ordersGroupsRepository.getById(id);
        ordersGroup.setStatus(Status.valueOf(status));
        ordersGroupsRepository.save(ordersGroup);
    }

}
