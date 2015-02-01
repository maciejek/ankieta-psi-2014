package pl.wroc.pwr.ankieta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.wroc.pwr.ankieta.entity.Uzytkownik;
import pl.wroc.pwr.ankieta.service.UzytkownikService;

@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UzytkownikService userService;
    
    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    
    @RequestMapping("/users/{email}")
    public String detail(Model model, @PathVariable String email) {
        model.addAttribute("user", userService.findOne(email));
        return "user-account";
    }
    
    @RequestMapping("/account")
    public String account(Model model) {
        Uzytkownik currentUser = userService.getLoggedUser();
        model.addAttribute("user", currentUser);
        return "user-account";
    }
}
