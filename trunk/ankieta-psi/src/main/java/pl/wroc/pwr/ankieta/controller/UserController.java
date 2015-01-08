package pl.wroc.pwr.ankieta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.wroc.pwr.ankieta.entity.User;
import pl.wroc.pwr.ankieta.service.UserService;

@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    
    @RequestMapping("/users/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.findOne(id));
        return "user-account";
    }
    
    @RequestMapping("/account")
    public String account(Model model) {
        User currentUser = userService.getLoggedUser();
        model.addAttribute("user", currentUser);
        return "user-account";
    }
}
