package pl.wroc.pwr.ankieta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Pytanie;
import pl.wroc.pwr.ankieta.entity.Szablon;
import pl.wroc.pwr.ankieta.repository.PytanieRepository;

@Service
public class PytanieService {

	PytanieRepository repository;

	public List<Pytanie> findAllForSzablon(Szablon szablon) {
		throw new UnsupportedOperationException();
	}

}