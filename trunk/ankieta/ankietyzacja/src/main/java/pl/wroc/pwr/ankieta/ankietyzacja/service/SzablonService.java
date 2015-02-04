package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
import pl.wroc.pwr.ankieta.ankietaService.repository.SzablonRepository;

@Service
public class SzablonService {

	SzablonRepository repository;

	public List<Szablon> findAll() {
		throw new UnsupportedOperationException();
	}

}