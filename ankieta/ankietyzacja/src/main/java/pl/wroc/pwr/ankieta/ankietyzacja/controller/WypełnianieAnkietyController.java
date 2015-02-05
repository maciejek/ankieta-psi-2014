package pl.wroc.pwr.ankieta.ankietyzacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietyzacja.model.WypelnianieAnkietyModel;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaAnkietowanegoService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaService;

@Controller
public class Wype³nianieAnkietyController {

    @Autowired
	AnkietaService ankietaService;

    @Autowired
	AnkietaAnkietowanegoService ankietaAnkietowanegoService;

    @RequestMapping("/wypelnianieListaAnkiet/{idAnkiety}")
	public String loadAnkieta(Model model, @PathVariable int idAnkiety) {
        Ankieta a = ankietaService.findAnkieta(idAnkiety);
        System.out.println((ankietaService.findAnkieta(idAnkiety)).getPytania());
        model.addAttribute("ankieta", ankietaService.findAnkieta(idAnkiety));
		return "wypelnij";
	}
    
    @RequestMapping("/wypelnianieListaAnkiet")
    public String wypelnianieAnkiety(Model model) {
        model.addAttribute("ankiety", ankietaService.findAll());
        return "wypelnianieListaAnkiet";
    }

	public String saveAnkietaAnkietowanego(WypelnianieAnkietyModel model) {
	    return "";
	}

}