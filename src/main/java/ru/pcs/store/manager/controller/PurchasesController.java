package ru.pcs.store.manager.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pcs.store.manager.model.Product;
import ru.pcs.store.manager.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PurchasesController {

    private final ProductService productService;

    @GetMapping("/purchases")
    public String getPurchasesPage(Model model) {
        List<Product> products = productService.findAllByLeftoversIsLessThan(1);
        model.addAttribute("products", products);
        return "purchases";
    }
}
