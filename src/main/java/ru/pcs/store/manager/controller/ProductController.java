package ru.pcs.store.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.pcs.store.manager.form.ProductForm;
import ru.pcs.store.manager.model.Product;
import ru.pcs.store.manager.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/products/add")
    public String create(ProductForm form) {
        productService.create(form);
        return "redirect:/products";
    }

    @GetMapping(value = "/products")
    public String readAll(Model model) {
        List<Product> products = productService.readAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping(value = "/products/{product-id}")
    public String read(Model model, @PathVariable(name = "product-id") Long productId) {
        Product product = productService.read(productId);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping(value = "/products/{product-id}/update")
    public String update(@PathVariable(name = "product-id") Long productId, ProductForm productForm) {
        productService.update(productId, productForm);
        return "redirect:/products/{product-id}";
    }

    @PostMapping(value = "/products/{product-id}/delete")
    public String delete(@PathVariable(name = "product-id") Long productId) {
        productService.delete(productId);
        return "redirect:/products";
    }
}
