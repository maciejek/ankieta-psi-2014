package pl.wroc.pwr.ankieta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wroc.pwr.ankieta.entity.Uzytkownik;
import pl.wroc.pwr.ankieta.service.UzytkownikService;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UzytkownikService userService;
    
    @RequestMapping
    public String showRegister() {
        return "user-register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") Uzytkownik user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }
        userService.registerUser(user);
        return "redirect:/register.html?success=true";
    }
    
    @RequestMapping("/available")
    @ResponseBody
    public String available(@RequestParam String email) {
        Boolean isEmailAvailable = userService.findOne(email) == null;
        return String.valueOf(isEmailAvailable);
    }
}
