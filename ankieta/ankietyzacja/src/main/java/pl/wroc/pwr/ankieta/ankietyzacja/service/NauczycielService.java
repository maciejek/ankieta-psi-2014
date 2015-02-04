package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.repository.NauczycielRepository;

@Service
public class NauczycielService {

	NauczycielRepository repository;

	public List<Nauczyciel> findAll() {
		throw new UnsupportedOperationException();
	}

}