//package ru.pcs.store.manager.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import ru.pcs.store.manager.form.AmountForm;
//import ru.pcs.store.manager.model.Amount;
//import ru.pcs.store.manager.service.AmountService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//public class AmountController {
//
//    private final AmountService amountService;
//
//    @PostMapping(value = "/amounts")
//    public String create(AmountForm amountForm) {
//        amountService.create(amountForm);
//        return "redirect:/amounts";
//    }
//
//    @GetMapping(value = "/amounts")
//    public String readAll (Model model) {
//        List<Amount> amounts = amountService.readAll();
//        model.addAttribute("amounts", amounts);
//        return "amounts";
//    }
//
//    @GetMapping(value = "/amounts/{id}")
//    public String read(Model model, @PathVariable(name = "id") Long id) {
//        final Amount amount = amountService.read(id);
//        model.addAttribute("amount", amount);
//        return "amounts";
//    }
//
//    @PostMapping(value = "/amounts/{id}")
//    public String update(@PathVariable ("id") Long id, AmountForm amountForm) {
//        amountService.update(id, amountForm);
//        return "redirect:/amounts/{id}";
//    }
//
//    @PostMapping(value = "/amounts/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        amountService.delete(id);
//        return "redirect:/amounts";
//    }
//
//    @PostMapping(value = "/amounts/{id}")
//    public String makeAmountFullSettlement(@PathVariable("id") Long id) {
//        amountService.makeAmountFullSettlement(id);
//        return "redirect:/amounts";
//    }
//
//    @PostMapping(value = "/amounts/{id}")
//    public String makeAmountCompensation(@PathVariable("id") Long id) {
//        amountService.makeAmountCompensation(id);
//        return "redirect:/amounts";
//    }
//
//    @PostMapping(value = "/amounts/{id}")
//    public String makeAmountPrepayment(@PathVariable("id") Long id) {
//        amountService.makeAmountPrepayment(id);
//        return "redirect:/amounts";
//    }
//}
