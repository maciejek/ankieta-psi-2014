package pl.wroc.pwr.ankieta.controller;

import org.springframework.stereotype.Controller;

import pl.wroc.pwr.ankieta.model.WypelnianieAnkietyModel;
import pl.wroc.pwr.ankieta.service.AnkietaAnkietowanegoService;
import pl.wroc.pwr.ankieta.service.AnkietaService;

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