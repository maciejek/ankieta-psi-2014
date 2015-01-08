package pl.wroc.pwr.ankieta.controller;

import org.springframework.stereotype.Controller;

import pl.wroc.pwr.ankieta.model.AnkietaModel;
import pl.wroc.pwr.ankieta.service.AnkietaService;
import pl.wroc.pwr.ankieta.service.AnkietowanyService;
import pl.wroc.pwr.ankieta.service.NauczycielService;
import pl.wroc.pwr.ankieta.service.PytanieService;
import pl.wroc.pwr.ankieta.service.SzablonService;
import pl.wroc.pwr.ankieta.service.ZajeciaService;

@Controller
public class NowaAnkietaController {

	NauczycielService nauczycielService;

	ZajeciaService zajeciaService;

	AnkietowanyService ankietowanyService;

	SzablonService szablonService;

	PytanieService pytanieSzablon;

	AnkietaService ankietaService;

	public String loadKrok1(AnkietaModel model1) {
	    return "";
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