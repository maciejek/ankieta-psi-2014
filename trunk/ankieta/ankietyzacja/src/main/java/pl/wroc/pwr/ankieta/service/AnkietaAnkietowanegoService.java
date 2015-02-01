package pl.wroc.pwr.ankieta.service;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.AnkietaAnkietowanego;
import pl.wroc.pwr.ankieta.model.WypelnianieAnkietyModel;
import pl.wroc.pwr.ankieta.repository.AnkietaAnkietowanegoRepository;

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