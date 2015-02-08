package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietaService.repository.ZajeciaRepository;

@Service
public class ZajeciaService {

    @Autowired
	ZajeciaRepository zajeciaRepository;

	public List<Zajecia> findAllForNauczyciel(Nauczyciel nauczyciel) {
		return zajeciaRepository.findAllForNauczyciel(nauczyciel);
	}
	
	public Zajecia findById(Integer id) {
	    return zajeciaRepository.findById(id);
	}

}