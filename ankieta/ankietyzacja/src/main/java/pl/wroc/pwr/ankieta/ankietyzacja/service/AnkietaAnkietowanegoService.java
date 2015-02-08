package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.entity.AnkietaAnkietowanego;
import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Odpowiedz;
import pl.wroc.pwr.ankieta.ankietaService.entity.OdpowiedzPytanieOtwarte;
import pl.wroc.pwr.ankieta.ankietaService.entity.Otwarte;
import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
import pl.wroc.pwr.ankieta.ankietaService.entity.Uzytkownik;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaAnkietowanegoRepository;
import pl.wroc.pwr.ankieta.ankietyzacja.model.WypelnianieAnkietyModel;

@Service
public class AnkietaAnkietowanegoService {

    @Autowired
	AnkietaAnkietowanegoRepository ankietaAnkietowanegoRepository;

	public AnkietaAnkietowanego createAnkietaAnkietowanego(WypelnianieAnkietyModel model, Ankieta ankieta, Uzytkownik ankietowany) {
	    AnkietaAnkietowanego ankietaAnkietowanego = new AnkietaAnkietowanego();
	    ankietaAnkietowanego.setAnkieta(ankieta);
	    ankietaAnkietowanego.setAnkietowany((Ankietowany)ankietowany);
	    System.out.println((Ankietowany)ankietowany);
	    ankietaAnkietowanego.setOdpowiedzi(convertOdpowiedziFromViewToListOfOdpowiedz(model.getOdpowiedziOtwarte(), ankieta.getPytania()));
	    return ankietaAnkietowanego;
	}

	public AnkietaAnkietowanego save(AnkietaAnkietowanego ankietaAnkietowanego) {
		ankietaAnkietowanego.setCzyUkonczona(true);
		return ankietaAnkietowanegoRepository.save(ankietaAnkietowanego);
	}
	
	private List<Odpowiedz> convertOdpowiedziFromViewToListOfOdpowiedz(List<String> odpowiedzi, List<Pytanie> pytania) {
	    List<Odpowiedz> result = new ArrayList<Odpowiedz>();
	    for(int i = 0; i<pytania.size(); i++) {
	        if(pytania.get(i) instanceof Otwarte) {
	            OdpowiedzPytanieOtwarte odpowiedz = new OdpowiedzPytanieOtwarte(odpowiedzi.get(i));
	            odpowiedz.setPytanie(pytania.get(i));
	            result.add(odpowiedz);
	        }
	    }
	    return result;
	}

}