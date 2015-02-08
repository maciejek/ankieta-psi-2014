package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
import pl.wroc.pwr.ankieta.ankietaService.repository.SzablonRepository;

@Service
public class SzablonService {

    @Autowired
	SzablonRepository szablonRepository;

	public List<Szablon> findAll() {
		return szablonRepository.findAll();
	}

}