package pl.wroc.pwr.ankieta.ankietyzacja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wroc.pwr.ankieta.ankietyzacja.model.WypelnianieAnkietyModel;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaAnkietowanegoService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaService;

@Controller
public class Wype³nianieAnkietyController {

    @Autowired
	AnkietaService ankietaService;

    @Autowired
	AnkietaAnkietowanegoService ankietaAnkietowanegoService;
    
    @ModelAttribute("wypelniona")
    public WypelnianieAnkietyModel construct() {
        return new WypelnianieAnkietyModel();
    }

    @RequestMapping("/wypelnianieListaAnkiet/{idAnkiety}")
	public String loadAnkieta(Model model, @PathVariable int idAnkiety) {
        model.addAttribute("ankieta", ankietaService.findAnkieta(idAnkiety));
		return "wypelnij";
	}
    
    @RequestMapping("/wypelnianieListaAnkiet")
    public String wypelnianieAnkiety(Model model) {
        model.addAttribute("ankiety", ankietaService.findAll());
        return "wypelnianieListaAnkiet";
    }
    
    @RequestMapping(value="/wypelnianieListaAnkiet/ankietaWypelniona", method = RequestMethod.POST)
    public String wypelnianieAnkiety(@Valid @ModelAttribute("wypelniona") WypelnianieAnkietyModel wypelniona, BindingResult result) {
        System.out.println("hola!");
        System.out.println(wypelniona);
        return "wypelnij";
    }

	public String saveAnkietaAnkietowanego(WypelnianieAnkietyModel model) {
	    return "";
	}

}