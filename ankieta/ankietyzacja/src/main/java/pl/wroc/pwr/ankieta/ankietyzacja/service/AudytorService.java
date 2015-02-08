package pl.wroc.pwr.ankieta.ankietyzacja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Audytor;
import pl.wroc.pwr.ankieta.ankietaService.repository.AudytorRepository;

@Service
public class AudytorService {

    @Autowired
	AudytorRepository audytorRepository;
	
	public Audytor findByEmail(String email) {
	    return audytorRepository.findByEmail(email);
	}

}