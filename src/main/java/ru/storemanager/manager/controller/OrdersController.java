package ru.storemanager.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.storemanager.manager.models.order.Order;
import ru.storemanager.manager.services.order.OrdersService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Controller
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/products/{id}/to_kart")
    public String productToKart(Model model,
                                @PathVariable("id") Long productId,
                                @RequestParam("count") Integer count,
                                Principal user){
        ordersService.addProductToKart(productId, user.getName(), count);
        return "redirect:/index";
    }

    @GetMapping("/cart")
    public String getKartPage (Model model, Principal user) {
        List<Order> orders = ordersService.getCartList(user.getName());
        BigDecimal totalPrice = ordersService.getTotalPrice(orders);
        model.addAttribute("orders", orders);
        model.addAttribute("totalprice", totalPrice);
        return "cart";
    }

    @PostMapping("/cart/{orderId}/delete")
    public String deleteProductFromCart(Model model,
                                        @PathVariable("orderId") Long orderId){
        ordersService.deleteById(orderId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/{orderId}/increaseCount")
    public String increaseProductCountInCart(Model model,
                                             @PathVariable("orderId") Long orderId) {
        ordersService.increaseDecreaseCountById(orderId, (int) 1);
        return "redirect:/cart";
    }
    @PostMapping("/cart/{orderId}/decreaseCount")
    public String decreaseProductCountInCart(Model model,
                                             @PathVariable("orderId") Long orderId) {
        ordersService.increaseDecreaseCountById(orderId, (int) -1);
        return "redirect:/cart";
    }
}
