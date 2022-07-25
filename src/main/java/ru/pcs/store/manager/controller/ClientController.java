package ru.pcs.store.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import ru.pcs.store.manager.form.ClientForm;
import ru.pcs.store.manager.model.Client;
import ru.pcs.store.manager.service.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Validated
public class ClientController {

    private final ClientService clientService;

    @GetMapping(value = "/clients")
    public String readAll(Model model) {
        List<Client> clients = clientService.readAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping(value = "/clients/{id}")
    public String read(Model model, @PathVariable(name = "id") Long id) {
        Client client = clientService.read(id);
        model.addAttribute("client", client);
        return "client";
    }

    @PostMapping(value = "/clients/add")
    public String create(ClientForm form) {
        clientService.create(form);
        return "redirect:/clients";
    }

    @PostMapping (value = "/clients/{id}/update")
    public String update(@PathVariable(name = "id") Long id, @Valid ClientForm form) {
        clientService.update(id, form);
        return "redirect:/clients/{id}";
    }

    @PostMapping(value = "/clients/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
//
//    @PostMapping(value = "/clients/{id}/status/active")
//    public String makeClientStatusActive(@PathVariable(name = "id") Long id){
//        clientService.makeClientStatusActive(id);
//        return "redirect:/clients/{id}";
//    }
//
//    @PostMapping(value = "/clients/{id}/status/passive")
//    public String makeClientStatusPassive(@PathVariable(name = "id") Long id){
//        clientService.makeClientStatusPassive(id);
//        return "redirect:/clients/{id}";
//    }
//
//    @PostMapping(value = "/clients/{id}/status/archive")
//    public String makeClientStatusArchive(@PathVariable(name = "id") Long id){
//        clientService.makeClientStatusArchive(id);
//        return "redirect:/clients/{id}";
//    }
}
