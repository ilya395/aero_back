package ru.pcs.store.manager.service.impl;

import ru.pcs.store.manager.enums.ProductStatus;
import ru.pcs.store.manager.form.ProductForm;
import ru.pcs.store.manager.model.Balance;
import ru.pcs.store.manager.model.Product;
import ru.pcs.store.manager.repositories.ProductRepository;
import ru.pcs.store.manager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void create(ProductForm form) {
        Product product = Product.builder()
                .name(form.getName())
                .color(form.getColor())
                .material(form.getMaterial())
                .size(form.getSize())
                .status(ProductStatus.enough)
                .totalNumber(0)
                .leftovers(0)
                .booked(0)
                .margin(BigDecimal.valueOf(0))
                .purchasePrice(BigDecimal.valueOf(0))
                .sellingPrice(BigDecimal.valueOf(0))
                .balances(new ArrayList<>())
                .build();
        productRepository.save(product);
    }

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByLeftoversIsLessThan(Integer number) {
        return productRepository.findAllByLeftoversIsLessThan(number);
    }

    @Override
    public Product read(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void update(Long id, ProductForm form) {
        Product product = productRepository.getById(id);
        product.setName(form.getName());
        product.setColor(form.getColor());
        product.setMaterial(form.getMaterial());
        product.setSize(form.getSize());
        productRepository.save(product);
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
}
