package pl.wroc.pwr.ankieta.service;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Ankieta;
import pl.wroc.pwr.ankieta.model.AnkietaModel;
import pl.wroc.pwr.ankieta.repository.AnkietaRepository;

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