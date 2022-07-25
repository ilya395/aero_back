package ru.storemanager.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.storemanager.manager.models.category.Category;
import ru.storemanager.manager.services.category.CategoriesService;

import java.util.List;

@Controller
public class CategoriesController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/admin/categories")
    public String getCategoriesPage(Model model){
        List<Category> categories = categoriesService.getAllWhereIdNotOneSortedByLevel();
        List<Category> parents = categoriesService.getAvailableParents();
        model.addAttribute("categories", categories);
        model.addAttribute("parents", parents);
        return "admin_categories";
    }

    @PostMapping("/admin/products/{category_id}/editCategory")
    public String editCategory(@PathVariable ("category_id") Long categoryId, Category category){
        categoriesService.updateCategory(categoryId, category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/admin/categories/addCategory")
    public String addCategory(Category category){
        categoriesService.addCategory(category);
        return "redirect:/admin/categories";
    }
}
