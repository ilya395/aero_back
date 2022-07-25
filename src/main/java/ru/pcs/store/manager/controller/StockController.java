package ru.pcs.store.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pcs.store.manager.model.Balance;
import ru.pcs.store.manager.service.BalanceService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StockController {

    private final BalanceService balanceService;

    @GetMapping("/stock")
    public String getStockPage(Model model) {
        List<Balance> balances = balanceService.readAll();
        model.addAttribute("balances", balances);
        return "stock";
    }
}
