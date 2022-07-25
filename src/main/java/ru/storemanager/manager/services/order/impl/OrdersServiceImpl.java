package ru.storemanager.manager.services.order.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.storemanager.manager.models.order.Order;
import ru.storemanager.manager.models.product.Product;
import ru.storemanager.manager.models.user.User;
import ru.storemanager.manager.repositories.OrdersRepository;
import ru.storemanager.manager.repositories.ProductsRepository;
import ru.storemanager.manager.repositories.UsersRepository;
import ru.storemanager.manager.services.order.OrdersService;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final ProductsRepository productsRepository;
    private final UsersRepository usersRepository;

    @Override
    public void addProductToKart(Long productId, String email, Integer count) {
        Product product = productsRepository.getById(productId);
        product.setCount(product.getCount()-count);
        productsRepository.save(product);
        User user = usersRepository.getByEmail(email);
        Optional<Order> optionalOrder =  ordersRepository.findOrderByProductAndUserAndOrdersGroup(product,user, null);
        if(optionalOrder.isEmpty()){
            Order order = Order.builder()
                    .count(count)
                    .product(product)
                    .user(user)
                    .ordersGroup(null)
                    .build();
            ordersRepository.save(order);
        }else{
            Order order = optionalOrder.get();
            order.setCount(order.getCount() + count);
            ordersRepository.save(order);
        }
    }

    @Override
    public List<Order> getCartList(String email) {
        User user = usersRepository.getByEmail(email);
        return ordersRepository.findOrderByUserAndOrdersGroupOrderByIdDesc(user,
                null).get();
    }

    @Override
    public void deleteById(Long orderId) {
        Order order = ordersRepository.getById(orderId);
        Product product = order.getProduct();
        product.setCount(product.getCount()+order.getCount());
        productsRepository.save(product);
        ordersRepository.deleteById(orderId);
    }

    @Override
    public void increaseDecreaseCountById(Long orderId,int count) {
        Order order = ordersRepository.getById(orderId);
        Product product = order.getProduct();
        if (count>0 & product.getCount() > 0 || count<0){
            product.setCount(product.getCount()-count);
            productsRepository.save(product);
            order.setCount(order.getCount()+count);
            ordersRepository.save(order);
        }
        if (order.getCount() == 0){ ordersRepository.delete(order);}
    }

    @Override
    public BigDecimal getTotalPrice(List<Order> orders) {
        Iterator iterator = orders.iterator();
        BigDecimal totalPrice = new BigDecimal(0);
        BigDecimal totalPriceI = new BigDecimal(0);
        while (iterator.hasNext()){
            Order order = (Order) iterator.next();
            totalPriceI = order.getProduct().getPrice().multiply(new BigDecimal(order.getCount()));
            totalPrice = totalPrice.add(totalPriceI);
        }
        return totalPrice;
    }

    @Override
    public List<Order> getOrdersByOrdersGroupId(Long ordersGroupId) {
        return ordersRepository.getByOrdersGroupId(ordersGroupId, Sort.by(Sort.Direction.ASC, "id"));
    }
}
