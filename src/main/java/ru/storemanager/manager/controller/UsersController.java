package ru.storemanager.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.storemanager.manager.forms.UserDto;
import ru.storemanager.manager.models.user.User;
import ru.storemanager.manager.services.user.UsersService;

import java.security.Principal;
import java.util.List;

@Controller
public class UsersController {

    final private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/admin")
    public String getAdminMenu(){
        return "Admin";
    }

    @GetMapping("/admin/users")
    public String toUsersPage(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping ("/admin/users/{id}/makeadmin")
    public String makeUserAdmin(@PathVariable("id") Long id){
        usersService.makeUserAdmin(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/signIn")
    public String signIn(){
        return "signIn";
    }

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpUser (UserDto userDto){
        usersService.singUpUser(userDto);
        return "redirect:/signIn";
    }

    @PostMapping("/lk")
    public String updateUser (UserDto userDto, Principal user){
        usersService.updateUser(userDto, user.getName());
        return "redirect:/lk";
    }
}
