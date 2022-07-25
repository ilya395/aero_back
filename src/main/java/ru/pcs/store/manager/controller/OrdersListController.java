package ru.pcs.store.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.pcs.store.manager.form.OrdersListForm;
import ru.pcs.store.manager.model.OrdersList;
import ru.pcs.store.manager.service.OrdersListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrdersListController {

    private final OrdersListService ordersListService;

    @PostMapping(value = "/orders/{order-id}/list/add")
    public String create(OrdersListForm form) {
        ordersListService.create(form);
        return "redirect:/orders/{order-id}/list";
    }

    @GetMapping(value = "/orders/{order-id}/list")
    public String readAll(Model model) {
        List<OrdersList> ordersLists = ordersListService.readAll();
        model.addAttribute("ordersList", ordersLists);
        return "/orders/{order-id}/list";
    }

    @GetMapping(value = "/orders/{order-id}/list/{list-id}")
    public String read(Model model, @PathVariable(name = "order-id") Long orderId) {
        OrdersList ordersLists = ordersListService.read(orderId);
        model.addAttribute("ordersLists", ordersLists);
        return "/orders/{order-id}/list/{list-id}";
    }

    @PostMapping(value = "/orders/{order-id}/list/{list-id}/update")
    public String update(@PathVariable(name = "order-id") Long orderId, OrdersListForm ordersListForm) {
        ordersListService.update(orderId, ordersListForm);
        return "redirect:/orders/{order-id}/list/{list-id}";
    }

    @PostMapping(value = "/orders/{order-id}/list/{list-id}/delete")
    public String delete(@PathVariable(name = "order-id") Long orderId) {
        ordersListService.delete(orderId);
        return "redirect:/orders/{order-id}/list/{list-id}";
    }
}
