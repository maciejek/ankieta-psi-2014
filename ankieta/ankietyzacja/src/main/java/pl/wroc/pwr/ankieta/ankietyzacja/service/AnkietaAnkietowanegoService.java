package pl.wroc.pwr.ankieta.ankietyzacja.service;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.AnkietaAnkietowanego;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaAnkietowanegoRepository;
import pl.wroc.pwr.ankieta.ankietyzacja.model.WypelnianieAnkietyModel;

@Service
public class AnkietaAnkietowanegoService {

	AnkietaAnkietowanegoRepository ankietaAnkietowanegoRepository;

	public AnkietaAnkietowanego createAmloetaAnkietowanego(WypelnianieAnkietyModel model) {
	    return null;
	}

	public AnkietaAnkietowanego save(AnkietaAnkietowanego ankietaAnkietowanego) {
		throw new UnsupportedOperationException();
	}

}