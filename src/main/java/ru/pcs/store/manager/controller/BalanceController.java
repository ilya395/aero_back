package ru.pcs.store.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.pcs.store.manager.form.BalanceForm;
import ru.pcs.store.manager.model.Balance;
import org.springframework.web.bind.annotation.*;
import ru.pcs.store.manager.service.BalanceService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping(value = "/balances")
    public String readAll(Model model) {
        List<Balance> balances = balanceService.readAll();
        model.addAttribute("balances", balances);
        return "balances";
    }

    @GetMapping(value = "/products/{product-id}/read")
    public String readAllByProductId(Model model, @PathVariable("product-id") Long productId) {
        List<Balance> balances = balanceService.readAllByProductId(productId);
        model.addAttribute("balances", balances);
        return "product";
    }

    @GetMapping(value = "/balances/{balances-id}")
    public String read(Model model, @PathVariable("balances-id") Long balancesId) {
        Balance balance = balanceService.read(balancesId);
        model.addAttribute("balances", balance);
        return "balance";
    }

    //todo check
    @PostMapping(value = "/product/{product-id}/addBalance")
    public String create(@PathVariable ("product-id") Long productId, BalanceForm form) {
        balanceService.create(form, productId);
        return "redirect:/product/{product-id}/";
    }

    @PostMapping(value = "/balances/{balances-id}/update")
    public String update(@PathVariable ("balances-id") Long balancesId, BalanceForm balanceForm){
        balanceService.update(balancesId, balanceForm);
        return "redirect:/balances";
    }

    @PostMapping(value = "/balances/{balances-id}/delete")
    public String delete(@PathVariable(name = "balances-id") Long id) {
        balanceService.delete(id);
        return "redirect:/balances";
    }
}
