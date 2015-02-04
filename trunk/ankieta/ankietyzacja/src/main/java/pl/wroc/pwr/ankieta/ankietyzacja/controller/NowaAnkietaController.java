package pl.wroc.pwr.ankieta.ankietyzacja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.wroc.pwr.ankieta.ankietyzacja.model.AnkietaModel;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietowanyService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.NauczycielService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.PytanieService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.SzablonService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.ZajeciaService;

@Controller
public class NowaAnkietaController {

	NauczycielService nauczycielService;

	ZajeciaService zajeciaService;

	AnkietowanyService ankietowanyService;

	SzablonService szablonService;

	PytanieService pytanieSzablon;

	AnkietaService ankietaService;

	@RequestMapping("/nowaAnkieta")
	public String loadKrok1(AnkietaModel model1) {
	    return "nowaAnkieta";
	}

	public String loadKrok2(AnkietaModel model2) {
	    return "";
	}

	public String loadKrok3(AnkietaModel model3) {
	    return "";
	}

	public String applySzablon(AnkietaModel model) {
	    return "";
	}

	public String createAnkieta(AnkietaModel model) {
	    return "";
	}

}