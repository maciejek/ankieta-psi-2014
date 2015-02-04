package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietowanyRepository;

@Service
public class AnkietowanyService {

	AnkietowanyRepository repository;

	public List<Ankietowany> findAllForZajecia(Zajecia zajecia) {
		throw new UnsupportedOperationException();
	}

}