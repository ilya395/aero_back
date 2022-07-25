package ru.storemanager.manager.services.product.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.storemanager.manager.models.category.Category;
import ru.storemanager.manager.models.product.Product;
import ru.storemanager.manager.repositories.CategoriesRepository;
import ru.storemanager.manager.repositories.ProductsRepository;
import ru.storemanager.manager.services.product.ProductsService;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;

    @Override
    public List<Product> getAllProductsCountGe0() {
        return productsRepository.findAllByCountGreaterThan(0, Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void deleteProductById(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void editProduct(Long id, Product product) {
        product.setId(id);
        productsRepository.save(product);
    }

    @Override
    public void addProduct(Product product) {
        productsRepository.save(product);
    }

    @Override
    public List<Product> getByCategoryId(Long categoryId) {
        Category category = categoriesRepository.getById(categoryId);
        if(category.getSecondaryPath() == 0L){
            return productsRepository.getByCategoryPrimaryPath(category.getPrimaryPath());
        }else{
            return productsRepository.getByCategoryId(categoryId);
        }
    }
}
