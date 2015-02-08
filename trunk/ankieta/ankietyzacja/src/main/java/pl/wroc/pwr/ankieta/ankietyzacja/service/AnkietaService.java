package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.entity.AnkietaAnkietowanego;
import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaRepository;
import pl.wroc.pwr.ankieta.ankietyzacja.model.AnkietaModel;

@Service
public class AnkietaService {
    
    @Autowired
	AnkietaRepository repository;

	public Ankieta findAnkieta(Integer idAnkiety) {
		return repository.findOne(idAnkiety);
	}
	
	public List<Ankieta> findAll() {
	    return repository.findAll();
	}
	
	public List<Ankieta> findAllAvailableForAnkietowany(Ankietowany ankietowany) {
	    List<Ankieta> result = new ArrayList<Ankieta>();
	    for(Ankieta ankieta : findAll()) {
	        if(isAnkietaAvailable(ankieta) && isAnkietowanyOfAnkieta(ankietowany, ankieta) && isAnkietaNotDoneYet(ankieta, ankietowany)) {
	            result.add(ankieta);
	        }
	    }
	    return result;
	}
	
	private boolean isAnkietaAvailable(Ankieta ankieta) {
	    Date now = new Date();
	    return ankieta.getTerminRozpoczecia().before(now) && ankieta.getTerminZakonczenia().after(now);
	}
	
	private boolean isAnkietowanyOfAnkieta(Ankietowany ankietowany, Ankieta ankieta) {
        for(Ankieta a : ankietowany.getAnkiety()) {
            if(ankieta.getId().equals(a.getId())) {
                return true;
            }
        }
        return false;
	}
	
	private boolean isAnkietaNotDoneYet(Ankieta ankieta, Ankietowany ankietowany) {
	    for(AnkietaAnkietowanego ankietaAnkietowanego : ankietowany.getAnkietaAnkietowanego()) {
	        if(ankietaAnkietowanego.getAnkieta().getId().equals(ankieta.getId()) && ankietaAnkietowanego.getCzyUkonczona()) {
	            return false;
	        }
	    }
	    return true;    
	}

	public Ankieta createAnkieta(AnkietaModel model) {
	    return null;
	}

	public Ankieta save(Ankieta ankieta) {
		throw new UnsupportedOperationException();
	}

}