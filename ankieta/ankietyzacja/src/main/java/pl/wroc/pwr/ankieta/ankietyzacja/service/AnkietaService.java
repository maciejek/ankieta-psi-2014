package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaRepository;
import pl.wroc.pwr.ankieta.ankietyzacja.model.AnkietaModel;

@Service
public class AnkietaService {

    @Autowired
	AnkietaRepository repository;

	public Ankieta findAnkieta(Integer idAnkiety) {
		return repository.findOne(idAnkiety);
	}
	
	public List<Ankieta> findAll() {
	    return repository.findAll();
	}

	public Ankieta createAnkieta(AnkietaModel model) {
	    return null;
	}

	public Ankieta save(Ankieta ankieta) {
		throw new UnsupportedOperationException();
	}

}