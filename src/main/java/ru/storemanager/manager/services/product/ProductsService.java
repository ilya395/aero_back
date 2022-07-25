package ru.storemanager.manager.services.product;

import ru.storemanager.manager.models.product.Product;

import java.util.List;

public interface ProductsService {

    List<Product> getAllProductsCountGe0();

    void deleteProductById(Long id);

    List<Product> getAllProducts();

    void editProduct(Long id, Product product);

    void addProduct(Product product);

    List<Product> getByCategoryId(Long categoryId);
}

