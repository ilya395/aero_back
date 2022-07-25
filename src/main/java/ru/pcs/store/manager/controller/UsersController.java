package ru.pcs.store.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.store.manager.form.UserForm;
import ru.pcs.store.manager.model.Users;
import ru.pcs.store.manager.service.UsersService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;

    @PostMapping(value = "/users/add")
    public String create(UserForm form) {
        usersService.createUser(form);
        return "redirect:/users";
    }

    @GetMapping(value = "/users")
    public String readAll(Model model) {
        List<Users> users = usersService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/users/{id}")
    public String read(Model model, @PathVariable("id") Long id) {
        Users user = usersService.findById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping(value = "/users/{user-id}/update")
    public String update(@PathVariable(name = "user-id") Long userId, UserForm form) {
        usersService.update(userId, form);
        return "redirect:/users/{user-id}";
    }

    @PostMapping(value = "/users/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id) {
        usersService.delete(id);
        return "redirect:/users";
    }
}
