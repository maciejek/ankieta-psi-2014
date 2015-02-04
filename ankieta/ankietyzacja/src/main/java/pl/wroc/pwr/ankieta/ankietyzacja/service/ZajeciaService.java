package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietaService.repository.ZajeciaRepository;

@Service
public class ZajeciaService {

	ZajeciaRepository repository;

	public List<Zajecia> findAllForNauczyciel(Nauczyciel nauczyciel) {
		throw new UnsupportedOperationException();
	}

}