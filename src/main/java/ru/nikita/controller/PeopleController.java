//package ru.nikita.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import ru.nikita.dao.UserDao;
//
//@Controller
//@RequestMapping("/users")
//public class PeopleController {
//    private final UserDao userDao;
//
//    public PeopleController(UserDao userDao) {
//        this.userDao = userDao;
//    }
//    @GetMapping
//    public String index(Model model) {
//        model.addAttribute("users", userDao.index());
//        return "user/index";
//    }
//}
