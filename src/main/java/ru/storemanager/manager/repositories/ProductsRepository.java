package ru.storemanager.manager.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.storemanager.manager.models.product.Product;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long>{

    List<Product> findAllByCountGreaterThan(Integer count, Sort sort);

    List<Product> getByCategoryId (Long productId);

    List<Product> getByCategoryPrimaryPath (Long primaryPath);
}
