package pl.wroc.pwr.ankieta.ankietyzacja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Otwarte;
import pl.wroc.pwr.ankieta.ankietaService.repository.OtwarteRepository;

@Service
public class OtwarteService {
    
    @Autowired
    private OtwarteRepository otwarteRepository;
    
    public Otwarte save(Otwarte otwarte) {
        return otwarteRepository.save(otwarte);
    }
}
