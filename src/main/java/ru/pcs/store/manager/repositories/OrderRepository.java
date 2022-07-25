package ru.pcs.store.manager.repositories;

import ru.pcs.store.manager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
