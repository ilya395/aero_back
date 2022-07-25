package ru.pcs.store.manager.repositories;

import ru.pcs.store.manager.model.OrdersList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersListRepository extends JpaRepository<OrdersList, Long> {
}
