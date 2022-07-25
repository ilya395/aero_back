package ru.pcs.store.manager.repositories;

import ru.pcs.store.manager.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    List<Balance> findAllByProductIdOrderByPurchasePrice(Long productId);

    List<Balance> findAllByProductIdOrderBySellingPrice(Long productId);

    List<Balance> findAllByNumberGreaterThan(Integer number);

    void deleteAllByProductId(Long productId);
}
