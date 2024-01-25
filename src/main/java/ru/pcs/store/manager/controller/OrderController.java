package ru.pcs.store.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.pcs.store.manager.form.OrderForm;
import ru.pcs.store.manager.model.Order;
import ru.pcs.store.manager.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;

    public String create(OrderForm form) {
        orderService.create(form);
        return "redirect:/orders";
    }

    @GetMapping(value = "/orders")
    public String readAll(Model model) {
        List<Order> orders = orderService.readAll();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping(value = "/orders/{id}")
    public String read(Model model, @PathVariable(name = "id") Long id) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order";
    }

    @PostMapping(value = "/orders/{id}/update")
    public String update(@PathVariable(name = "id") Long id, OrderForm orderForm) {
        orderService.update(id, orderForm);
        return "redirect:/orders/{id}";
    }

    @PostMapping(value = "/orders/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        orderService.delete(id);
        return "redirect:/orders";
    }

    @PostMapping(value = "/orders/{id}/status/processing")
    public String makeOrderStatusProcessing(@PathVariable(name = "id") Long id) {
        orderService.makeOrderStatusProcessing(id);
        return "redirect:orders";
    }

    @PostMapping(value = "/orders/{id}/status/collecting")
    public String makeOrderStatusCollecting(@PathVariable(name = "id") Long id) {
        orderService.makeOrderStatusCollecting(id);
        return "redirect:orders";
    }

    @PostMapping(value = "/orders/{id}/status/proof")
    public String makeOrderStatusProofOfPayment(@PathVariable(name = "id") Long id) {
        orderService.makeOrderStatusProofOfPayment(id);
        return "redirect:orders";
    }

    @PostMapping(value = "/orders/{id}/status/shipped")
    public String makeOrderStatusShipped(@PathVariable(name = "id") Long id) {
        orderService.makeOrderStatusShipped(id);
        return "redirect:orders";
    }
}
