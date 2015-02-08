package pl.wroc.pwr.ankieta.ankietyzacja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.WariantOdpowiedzi;
import pl.wroc.pwr.ankieta.ankietaService.repository.WariantOdpowiedziRepository;

@Service
public class WariantOdpowiedziService {

    @Autowired
	private WariantOdpowiedziRepository wariantOdpowiedziRepository;
    
    public WariantOdpowiedzi save(WariantOdpowiedzi wariant) {
        return wariantOdpowiedziRepository.save(wariant);
    }

}