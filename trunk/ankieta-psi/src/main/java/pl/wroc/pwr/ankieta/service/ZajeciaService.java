package pl.wroc.pwr.ankieta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.entity.Zajecia;
import pl.wroc.pwr.ankieta.repository.ZajeciaRepository;

@Service
public class ZajeciaService {

	ZajeciaRepository repository;

	public List<Zajecia> findAllForNauczyciel(Nauczyciel nauczyciel) {
		throw new UnsupportedOperationException();
	}

}