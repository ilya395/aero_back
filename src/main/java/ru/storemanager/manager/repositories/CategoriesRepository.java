package ru.storemanager.manager.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.storemanager.manager.models.category.Category;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByIdGreaterThan(Long id, Sort sort);

    List<Category> getByParentId(Long parentId);

    List<Category> getByPrimaryPathAndSecondaryPath (Long primaryPath, Long secondaryPath);

    List<Category> getBySecondaryPath(Long secondaryPath);
}
