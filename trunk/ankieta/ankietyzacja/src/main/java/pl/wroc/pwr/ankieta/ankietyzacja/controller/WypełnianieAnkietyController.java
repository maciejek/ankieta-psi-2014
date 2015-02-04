package pl.wroc.pwr.ankieta.ankietyzacja.controller;

import org.springframework.stereotype.Controller;

import pl.wroc.pwr.ankieta.ankietyzacja.model.WypelnianieAnkietyModel;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaAnkietowanegoService;
import pl.wroc.pwr.ankieta.ankietyzacja.service.AnkietaService;

@Controller
public class Wype³nianieAnkietyController {

	AnkietaService ankietaService;

	AnkietaAnkietowanegoService ankietaAnkietowanegoService;

	public String loadAnkieta(Integer idAnkiety) {
		throw new UnsupportedOperationException();
	}

	public String saveAnkietaAnkietowanego(WypelnianieAnkietyModel model) {
	    return "";
	}

}