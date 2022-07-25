package ru.storemanager.manager.services.category;

import ru.storemanager.manager.models.category.Category;

import java.util.List;

public interface CategoriesService {

    List<Category> getAllWhereIdNotOneSortedByLevel();

    void updateCategory(Long Id, Category category);

    List<Category> getAvailableParents();

    void addCategory(Category category);
}

