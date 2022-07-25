package ru.pcs.store.manager.service;

import ru.pcs.store.manager.form.BalanceForm;
import ru.pcs.store.manager.model.Balance;
import ru.pcs.store.manager.model.Product;

import java.util.List;

public interface BalanceService {

    void create(BalanceForm form, Long productId);

    List<Balance> readAll();

    Balance read(Long id);

    List<Balance> readAllByProductId(Long productId);

    List<Balance> findAllByNumberGreaterThan(Integer number);

    void update(Long id, BalanceForm form);

    void delete(Long id);

    void deleteAllByProductId(Long productId);
}
