package pl.wroc.pwr.ankieta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Ankietowany;
import pl.wroc.pwr.ankieta.entity.Zajecia;
import pl.wroc.pwr.ankieta.repository.AnkietowanyRepository;

@Service
public class AnkietowanyService {

	AnkietowanyRepository repository;

	public List<Ankietowany> findAllForZajecia(Zajecia zajecia) {
		throw new UnsupportedOperationException();
	}

}