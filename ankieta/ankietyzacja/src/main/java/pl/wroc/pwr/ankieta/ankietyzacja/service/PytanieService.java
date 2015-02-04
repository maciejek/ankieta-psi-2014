package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
import pl.wroc.pwr.ankieta.ankietaService.repository.PytanieRepository;

@Service
public class PytanieService {

	PytanieRepository repository;

	public List<Pytanie> findAllForSzablon(Szablon szablon) {
		throw new UnsupportedOperationException();
	}

}