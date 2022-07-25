package ru.pcs.store.manager.service;

import ru.pcs.store.manager.form.ProductForm;
import ru.pcs.store.manager.model.Balance;
import ru.pcs.store.manager.model.Product;

import java.util.List;

public interface ProductService {

    void create(ProductForm form);

    List<Product> readAll();

    List<Product> findAllByLeftoversIsLessThan(Integer number);

    Product read(Long id);

    void update(Long id, ProductForm form);

    void delete(Long id);
}
