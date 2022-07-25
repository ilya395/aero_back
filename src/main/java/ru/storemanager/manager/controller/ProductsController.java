package ru.storemanager.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.storemanager.manager.models.category.Category;
import ru.storemanager.manager.models.product.Product;
import ru.storemanager.manager.services.category.CategoriesService;
import ru.storemanager.manager.services.product.ProductsService;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;
    private final CategoriesService categoriesService;

    @Autowired
    public ProductsController(ProductsService productService, CategoriesService categoriesService) {
        this.productsService = productService;
        this.categoriesService = categoriesService;
    }

    @GetMapping("/index")
    public String getProductsPage(Model model) {
        List<Product> products = productsService.getAllProductsCountGe0();
        List<Category> categories = categoriesService.getAllWhereIdNotOneSortedByLevel();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "products";
    }

    @PostMapping("/admin/products/{product-id}/delete")
    public String deleteProduct (@PathVariable("product-id") Long productId) {
        productsService.deleteProductById(productId);
        return "redirect:/index";
    }

    @GetMapping("/admin/products")
    public String getAllProductsPage (Model model) {
        List<Product> products = productsService.getAllProducts();
        List<Category> categories = categoriesService.getAllWhereIdNotOneSortedByLevel();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "admin_products";
    }

    @PostMapping("/admin/products/{product-id}/editProduct")
    public String changeProduct (@PathVariable("product-id") Long productId,
                                 Product product){
        productsService.editProduct(productId, product);
        return "redirect:/admin/products";
    }

    @PostMapping("/admin/products/addProduct")
    public String addProduct (Product product){
        productsService.addProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/productSortedByCategory/{category-id}")
    public String productByCategory (Model model, @PathVariable("category-id") Long categoryId){
        List<Category> categories = categoriesService.getAllWhereIdNotOneSortedByLevel();
        List<Product> products = productsService.getByCategoryId(categoryId);
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "products";
    }
}
