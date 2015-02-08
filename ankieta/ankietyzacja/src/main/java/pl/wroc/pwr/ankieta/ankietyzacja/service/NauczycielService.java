package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.repository.NauczycielRepository;

@Service
public class NauczycielService {

    @Autowired
	NauczycielRepository nauczycielRepository;

	public List<Nauczyciel> findAll() {
		return nauczycielRepository.findAll();
	}
	
	public Nauczyciel findById(Integer id) {
	    return nauczycielRepository.findById(id);
	}

}