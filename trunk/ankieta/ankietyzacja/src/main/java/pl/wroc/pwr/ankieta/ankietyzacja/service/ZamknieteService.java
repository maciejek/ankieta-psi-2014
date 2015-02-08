package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zamkniête;
import pl.wroc.pwr.ankieta.ankietaService.repository.PytanieRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.ZamknieteRepository;

@Service
public class ZamknieteService {

    @Autowired
	private ZamknieteRepository zamknieteRepository;
    
    public Zamkniête save(Zamkniête zamkniete) {
        return zamknieteRepository.save(zamkniete);
    }

	public List<Pytanie> findAllForSzablon(Szablon szablon) {
		throw new UnsupportedOperationException();
	}

}