package pl.wroc.pwr.ankieta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Szablon;
import pl.wroc.pwr.ankieta.repository.SzablonRepository;

@Service
public class SzablonService {

	SzablonRepository repository;

	public List<Szablon> findAll() {
		throw new UnsupportedOperationException();
	}

}