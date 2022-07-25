package ru.pcs.store.manager.repositories;

import ru.pcs.store.manager.model.Balance;
import ru.pcs.store.manager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByLeftoversIsLessThan(Integer number);

//    void addBalanceToList(Long productId, Balance balance);
}
