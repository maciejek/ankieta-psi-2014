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

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.entity.AnkietaAnkietowanego;
import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Uzytkownik;
import pl.wroc.pwr.ankieta.ankietyzacja.model.WypelnianieAnkietyModel;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaAnkietowanegoService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.UzytkownikService;

@Controller
public class WypełnianieAnkietyController {

    @Autowired
	AnkietaService ankietaService;

    @Autowired
	AnkietaAnkietowanegoService ankietaAnkietowanegoService;
    
    @Autowired
    UzytkownikService uzytkownikService;
    
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
        model.addAttribute("ankiety", ankietaService.findAllAvailableForAnkietowany((Ankietowany)uzytkownikService.getLoggedUser()));
        return "wypelnianieListaAnkiet";
    }
    
    @RequestMapping(value="/wypelnianieListaAnkiet/ankietaWypelniona", method = RequestMethod.POST)
    public String wypelnianieAnkiety(@Valid @ModelAttribute("wypelniona") WypelnianieAnkietyModel wypelniona, BindingResult result) {
        System.out.println(wypelniona);
        System.out.println(wypelniona.getAnkietaId());
        Ankieta ankieta = ankietaService.findAnkieta(wypelniona.getAnkietaId());
        Ankietowany ankietowany = (Ankietowany)uzytkownikService.getLoggedUser();
        AnkietaAnkietowanego ankietaAnkietowanego = ankietaAnkietowanegoService.createAnkietaAnkietowanego(wypelniona, ankieta, ankietowany);
        ankietaAnkietowanego = ankietaAnkietowanegoService.save(ankietaAnkietowanego);
        ankietowany.addAnkietaAnkietowanego(ankietaAnkietowanego);
        //return "redirect:/wypelnianieListaAnkiet.html?success=true";
       // return "/wypelnianieListaAnkiet2/"+ankietaAnkietowanego.getId();
        return "redirect:/wypelnianieListaAnkiet2/"+ankietaAnkietowanego.getId()+".html";

    }
    
    @RequestMapping("/wypelnianieListaAnkiet2/{idAnkietyAnkietowanego}")
    public String wypelnianieDone(Model model, @PathVariable int idAnkietyAnkietowanego) {
        model.addAttribute("ankietaAnkietowanego", ankietaAnkietowanegoService.findAnkietaAnkietowanego(idAnkietyAnkietowanego));
        return "redirect:/wypelnianieListaAnkiet.html?success=true";
    }

	public String saveAnkietaAnkietowanego(WypelnianieAnkietyModel model) {
	    return "";
	}

}