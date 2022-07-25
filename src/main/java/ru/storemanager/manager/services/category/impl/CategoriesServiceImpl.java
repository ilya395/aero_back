package ru.storemanager.manager.services.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.storemanager.manager.models.category.Category;
import ru.storemanager.manager.repositories.CategoriesRepository;
import ru.storemanager.manager.services.category.CategoriesService;

import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public List<Category> getAllWhereIdNotOneSortedByLevel() {
        return categoriesRepository.findAllByIdGreaterThan(1L, Sort.by(Sort.Direction.ASC, "primaryPath"));
    }

    @Override
    public void updateCategory(Long id, Category category) {
        category.setId(id);
        findCategoryPath(category);
    }

    @Override
    public List<Category> getAvailableParents() {
        return categoriesRepository.getBySecondaryPath(0L);
    }

    @Override
    public void addCategory(Category category) {
        findCategoryPath(category);
    }

    private void findCategoryPath(Category category) {
        Long parentId = category.getParentId();
        Category parent = categoriesRepository.getById(parentId);
        List<Category> allByParentId = categoriesRepository.getByParentId(parentId);
        Iterator iterator = allByParentId.iterator();
        if (parent.getPrimaryPath() == 0L){
            category.setSecondaryPath(0L);
            Long maxPrimaryPath = 0L;
            while (iterator.hasNext()) {
                Category categoryTemp = (Category) iterator.next();
                if (categoryTemp.getPrimaryPath() > maxPrimaryPath) {
                    maxPrimaryPath = categoryTemp.getPrimaryPath();
                }
            }
            category.setPrimaryPath(maxPrimaryPath + 1);
        }else{
            category.setPrimaryPath(parent.getPrimaryPath());
            Long maxSecondaryPath = 0L;
            while (iterator.hasNext()) {
                Category categoryTemp = (Category) iterator.next();
                if (categoryTemp.getSecondaryPath() > maxSecondaryPath) {
                    maxSecondaryPath = categoryTemp.getSecondaryPath();
                }
            }
            category.setSecondaryPath(maxSecondaryPath + 1);
        }
        categoriesRepository.save(category);
    }
}
