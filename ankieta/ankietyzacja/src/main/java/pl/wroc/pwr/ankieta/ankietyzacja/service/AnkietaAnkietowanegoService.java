package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import pl.wroc.pwr.ankieta.ankietaService.entity.WariantOdpowiedzi;
import pl.wroc.pwr.ankieta.ankietaService.entity.WybranaOdpowiedz;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zamkniete;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaAnkietowanegoRepository;
import pl.wroc.pwr.ankieta.ankietyzacja.model.WypelnianieAnkietyModel;

@Service
public class AnkietaAnkietowanegoService {

    @Autowired
	AnkietaAnkietowanegoRepository ankietaAnkietowanegoRepository;

	public AnkietaAnkietowanego createAnkietaAnkietowanego(WypelnianieAnkietyModel model, Ankieta ankieta, Ankietowany ankietowany) {
	    AnkietaAnkietowanego ankietaAnkietowanego = new AnkietaAnkietowanego();
	    ankietaAnkietowanego.setAnkieta(ankieta);
	    ankietaAnkietowanego.setAnkietowany(ankietowany);
	    ankietaAnkietowanego.setOdpowiedzi(convertOdpowiedziFromViewToListOfOdpowiedz(model.getOdpowiedzi(), ankieta.getPytania()));
	    return ankietaAnkietowanego;
	}

	public AnkietaAnkietowanego save(AnkietaAnkietowanego ankietaAnkietowanego) {
		ankietaAnkietowanego.setCzyUkonczona(true);
		return ankietaAnkietowanegoRepository.save(ankietaAnkietowanego);
	}
	
	private List<Odpowiedz> convertOdpowiedziFromViewToListOfOdpowiedz(List<String> odpowiedzi, List<Pytanie> pytania) {
	    List<Odpowiedz> result = new ArrayList<Odpowiedz>();
	    for(int i = 0; i<pytania.size(); i++) {
	        Odpowiedz odpowiedz = null;
	        if(pytania.get(i) instanceof Otwarte) {
	            odpowiedz = new OdpowiedzPytanieOtwarte(odpowiedzi.get(i));
	        }
	        else {
	            Zamkniete zamkniete = (Zamkniete)pytania.get(i);
	            WariantOdpowiedzi wybranyWariant = getWariantWithTresc(zamkniete.getWariantyOdpowiedzi(), odpowiedzi.get(i));
	            odpowiedz = new WybranaOdpowiedz(wybranyWariant);
	        }
            odpowiedz.setPytanie(pytania.get(i));
            result.add(odpowiedz);
	    }
	    return result;
	}
	
	private WariantOdpowiedzi getWariantWithTresc(Collection<WariantOdpowiedzi> warianty, String tresc) {
	    Iterator<WariantOdpowiedzi> wariantyIterator = warianty.iterator();
	    while(wariantyIterator.hasNext()) {
	        WariantOdpowiedzi wariant = wariantyIterator.next();
	        if(wariant.getTresc().equals(tresc)) {
	            return wariant;
	        }
	    }
	    return null;
	}
	
	public AnkietaAnkietowanego findAnkietaAnkietowanego(int id) {
	    return ankietaAnkietowanegoRepository.findOne(id);
	}
	
	public List<AnkietaAnkietowanego> findAll() {
	    return ankietaAnkietowanegoRepository.findAll();
	}

}