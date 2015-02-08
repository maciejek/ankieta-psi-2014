package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietowanyRepository;

@Service
public class AnkietowanyService {

    @Autowired
	AnkietowanyRepository ankietowanyRepository;

    public Ankietowany findOneById(Integer id) {
        return ankietowanyRepository.findOne(id);
    }
    
	public List<Ankietowany> findAllForZajecia(Zajecia zajecia) {
		return ankietowanyRepository.findAllForZajecia(zajecia);
	}

}