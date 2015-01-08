package pl.wroc.pwr.ankieta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.repository.NauczycielRepository;

@Service
public class NauczycielService {

	NauczycielRepository repository;

	public List<Nauczyciel> findAll() {
		throw new UnsupportedOperationException();
	}

}