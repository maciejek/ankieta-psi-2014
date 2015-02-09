package pl.wroc.pwr.ankieta.ankietyzacja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietyzacja.model.TworzenieAnkietyModel;
import pl.wroc.pwr.ankieta.ankietyzacja.model.AnkietaModel;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietowanyService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.NauczycielService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.PytanieService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.SzablonService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.ZajeciaService;

@Controller
@RequestMapping("/ankieta")
public class NowaAnkietaController {

    @Autowired
	NauczycielService nauczycielService;

    @Autowired
	ZajeciaService zajeciaService;

    @Autowired
	AnkietowanyService ankietowanyService;

    @Autowired
	SzablonService szablonService;

	PytanieService pytanieSzablon;

	@Autowired
	AnkietaService ankietaService;
	
	@ModelAttribute("model")
    public TworzenieAnkietyModel construct() {
        return new TworzenieAnkietyModel();
    }

	@RequestMapping("/nowaAnkieta")
	public String nowaAnkieta(Model model) {
	    return "nowaAnkieta";
	}
	
	@RequestMapping(value="/krok1", method = RequestMethod.POST, produces = "text/html")
	public String loadKrok1(Model model, AnkietaModel model1, Integer idNauczyciela) {
	    
	    Nauczyciel nauczyciel = nauczycielService.findById(idNauczyciela);
	    model1.setNauczyciel(nauczyciel);
	    
	    List<Nauczyciel> nauczyciele = nauczycielService.findAll();
        model1.setNauczyciele(nauczyciele);
        
        List<Zajecia> zajeciaDlaNauczyciela = null;
        
        if (model1.getNauczyciel() == null) {
            model1.setNauczyciel(nauczyciele.get(0));
            zajeciaDlaNauczyciela = zajeciaService.findAllForNauczyciel(model1.getNauczyciel());
        } else {
            zajeciaDlaNauczyciela = zajeciaService.findAllForNauczyciel(model1.getNauczyciel());
        }

        model1.setZajeciaDlaNauczyciela(zajeciaDlaNauczyciela);
        
        model.addAttribute("ankietaModel", model1); 
        
        return "krok1";
	}

	@RequestMapping(value="/krok2", method = RequestMethod.POST, produces = "text/html")
	public String loadKrok2(Model model, AnkietaModel model2, Integer idZajec) {
	    
	    Zajecia zajecia = zajeciaService.findById(idZajec);
	    model2.setZajecia(zajecia);
	    
	    List<Ankietowany> ankietowaniZZajec = ankietowanyService.findAllForZajecia(model2.getZajecia());
	    model2.setAnkietowaniDlaZajec(ankietowaniZZajec);
	    
	    model.addAttribute("ankietaModel", model2);
	    
	    return "krok2";
	}

	@RequestMapping(value="/krok3", method = RequestMethod.POST, produces = "text/html")
	public String loadKrok3(Model model, AnkietaModel model3) {
	    
	    List<Szablon> szablony = szablonService.findAll();
	    model3.setSzablony(szablony);
	    
	    model.addAttribute("ankietaModel", model3);
	    
	    return "krok3";
	}

	public String applySzablon(AnkietaModel model) {
	    return "";
	}

	@RequestMapping(value="/zapisz", method = RequestMethod.POST)
	public String createAnkieta(@ModelAttribute("model") TworzenieAnkietyModel model) {
	    model.getPytania().remove(model.getPytania().size() - 1);
	    Ankieta ankieta = ankietaService.createAnkieta(model);
	    ankietaService.save(ankieta);
	    return "dodanaAnkieta";
	}

}