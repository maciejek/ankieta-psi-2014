package pl.wroc.pwr.ankieta.ankietyzacja.service;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaRepository;
import pl.wroc.pwr.ankieta.ankietyzacja.model.AnkietaModel;

@Service
public class AnkietaService {

	AnkietaRepository repository;

	public Ankieta loadAnkieta(Integer idAnkiety) {
		throw new UnsupportedOperationException();
	}

	public Ankieta createAnkieta(AnkietaModel model) {
	    return null;
	}

	public Ankieta save(Ankieta ankieta) {
		throw new UnsupportedOperationException();
	}

}