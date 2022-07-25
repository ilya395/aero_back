package ru.storemanager.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.storemanager.manager.enums.PaymentMethod;
import ru.storemanager.manager.models.ordersgroup.OrdersGroup;
import ru.storemanager.manager.models.order.Order;
import ru.storemanager.manager.models.user.User;
import ru.storemanager.manager.services.ordersgroup.OrdersGroupsService;
import ru.storemanager.manager.services.order.OrdersService;
import ru.storemanager.manager.services.user.UsersService;

import java.security.Principal;
import java.util.List;

@Controller
public class OrdersGroupsController {

    private final OrdersService ordersService;
    private final OrdersGroupsService ordersGroupsService;
    private final UsersService usersService;

    @Autowired
    public OrdersGroupsController(OrdersService ordersService, OrdersGroupsService ordersGroupsService, UsersService usersService) {
        this.ordersService = ordersService;
        this.ordersGroupsService = ordersGroupsService;
        this.usersService = usersService;
    }

    @PostMapping("cart/checkout")
    public String checkoutOrder(Model model,
                                @RequestParam("address") String address,
                                @RequestParam("paymentMethod") PaymentMethod paymentMethod,
                                Principal user) {
        List<Order> orders = ordersService.getCartList(user.getName());
        ordersGroupsService.checkout(orders, address, paymentMethod, ordersService.getTotalPrice(orders));
        return "redirect:/lk";
    }

    @GetMapping("/lk")
    public String getOrdersGroupsPage(Model model, Principal user) {
        List<OrdersGroup> ordersGroups = ordersGroupsService.getByUserName(user.getName());
        User currentUser = usersService.getUserByEmail(user.getName());
        model.addAttribute("ordersGroups", ordersGroups);
        model.addAttribute("user", currentUser);
        return "lk";
    }

    @GetMapping("/admin/orders")
    public String getOrdersPage(Model model) {
        List<OrdersGroup> ordersGroups = ordersGroupsService.findAll();
        model.addAttribute("ordersGroups", ordersGroups);
        return "admin_orders";
    }

    @GetMapping("/admin/orders/{ordersGroup_id}")
    public String getOrdersGroupDetails(Model model, @PathVariable("ordersGroup_id") Long ordersGroupId){
        OrdersGroup ordersGroup = ordersGroupsService.getById(ordersGroupId);
        List<Order> orders = ordersService.getOrdersByOrdersGroupId(ordersGroupId);
        model.addAttribute("ordersGroup", ordersGroup);
        model.addAttribute("orders", orders);
        return "ordersGroupDetails";
    }

    @PostMapping("/admin/orders/{ordersGroup_id}/changeStatus")
    public String changeOrdersGroupStatus (@PathVariable("ordersGroup_id") Long ordersGroupId,
                                           @RequestParam("status") String status){
        ordersGroupsService.changeStatusById(ordersGroupId, status);
        return "redirect:/admin/orders";
    }
}
