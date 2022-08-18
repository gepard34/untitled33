package ru.nikita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nikita.dao.UserDao;
import ru.nikita.dao.UserDaoImpl;
import ru.nikita.model.User;
import ru.nikita.service.UserService;

import javax.persistence.EntityManagerFactory;
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "user/index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.edit(id, user);
        return "redirect:/users/";
    }

    @GetMapping("/delete/{id}")
    public String removeUser(@ModelAttribute("id") int id) {
        userService.delete(id);
        return "redirect:/users/";
    }
}
