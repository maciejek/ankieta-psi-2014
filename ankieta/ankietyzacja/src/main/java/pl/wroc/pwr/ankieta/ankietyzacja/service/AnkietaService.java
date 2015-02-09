package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.entity.AnkietaAnkietowanego;
import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Audytor;
import pl.wroc.pwr.ankieta.ankietaService.entity.Otwarte;
import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
import pl.wroc.pwr.ankieta.ankietaService.entity.WariantOdpowiedzi;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zamkniete;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaRepository;
import pl.wroc.pwr.ankieta.ankietyzacja.model.TworzenieAnkietyModel;
import pl.wroc.pwr.ankieta.ankietyzacja.model.AnkietaModel;

@Service
public class AnkietaService {

    @Autowired
	private AnkietaRepository ankietaRepository;
    
    @Autowired
    private AudytorService audytorService;
    
    @Autowired
    private ZajeciaService zajeciaService;
    
    @Autowired
    private ZamknieteService zamknieteService;
    
    @Autowired
    private OtwarteService otwarteService;
    
    @Autowired
    private WariantOdpowiedziService wariantOdpowiedziService;
    
    @Autowired
    private AnkietowanyService ankietowanyService;

	public Ankieta loadAnkieta(Integer idAnkiety) {
		throw new UnsupportedOperationException();
	}

	public Ankieta createAnkieta(TworzenieAnkietyModel model) {
	    
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    Audytor audytor = audytorService.findByEmail(authentication.getName());
	    
	    model.getGrupaAnkietowanych();
	    
	    Zajecia zajecia = zajeciaService.findById(model.getIdZajec());
	    
	    Ankieta ankieta = new Ankieta();
        save(ankieta);
       
	    ankieta.setTytul(model.getTytul());
	    ankieta.setTerminRozpoczecia(new Date());
	    ankieta.setTerminZakonczenia(getEndDateMock());
	    ankieta.setAudytor(audytor);
	    ankieta.setZajecia(zajecia);
	    ankieta.setGrupaAnkietowanych(readStudentsFromJSON(model.getGrupaAnkietowanych()));
	    
	    List<Pytanie> pytania = new ArrayList<Pytanie>();
	    
	    for (int i = 0; i < model.getPytania().size(); i++) {
	        Pytanie pytanie = readQuestionFromJSONAndSave(model.getPytania().get(i), ankieta);
	        pytania.add(pytanie);
	    }
	    
	    ankieta.setPytania(pytania);
	    
	    return ankieta;
	}
	
	private List<Ankietowany> readStudentsFromJSON(String json) {
	    
	    List<Ankietowany> studentsGroup = new ArrayList<Ankietowany>();
	    
	    JSONObject jsonObject = new JSONObject(json);
	    JSONArray group = jsonObject.getJSONArray("grupa");
	    
	    for (int i = 0; i < group.length(); i++) {
	        Integer id = group.getJSONObject(i).getInt("id");
	        Ankietowany ankietowany = ankietowanyService.findOneById(id);
	        studentsGroup.add(ankietowany);
	    }
	    
	    return studentsGroup;
	}
	
	private Pytanie readQuestionFromJSONAndSave(String json, Ankieta ankieta) {
	    
	    JSONObject jsonObject = new JSONObject(json);
	    String content = jsonObject.getString("tresc");
	    Boolean isOpened = jsonObject.getBoolean("czyOtwarte");
	    Boolean isNumeric = jsonObject.getBoolean("czyLiczbowy");
	    JSONArray variants = jsonObject.getJSONArray("warianty");
	    
	    if (isOpened) {
	        
	        Otwarte question = new Otwarte();
	        question.setTresc(content);
	        question.setAnkieta(ankieta);
	        
	        return otwarteService.save(question);
 	        
	    } else {
	        
	        Zamkniete question = new Zamkniete();
	        question.setTresc(content);
            question.setAnkieta(ankieta);
	        
	        zamknieteService.save(question);
	        
	        for (int i = 0; i < variants.length(); i++) {
	            String variantContent = variants.getJSONObject(i).getString("tresc");
	            
	            WariantOdpowiedzi answerVariant = new WariantOdpowiedzi();
	            
	            answerVariant.setCzyLiczbowy(isNumeric);
	            answerVariant.setTresc(variantContent);
	            answerVariant.setPytanieZamkniete(question);
	            
	            wariantOdpowiedziService.save(answerVariant);
	            
	            question.addWariantOdpowiedzi(answerVariant);
	        }
	        
            return zamknieteService.save(question);
	    }
	}
	
	private Date getEndDateMock() {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(2015, Calendar.DECEMBER, 31, 0, 0, 0);
	    return calendar.getTime();
	}

	public Ankieta save(Ankieta ankieta) {
		return ankietaRepository.save(ankieta);
	}

    public Ankieta findAnkieta(Integer idAnkiety) {
        return ankietaRepository.findOne(idAnkiety);
    }
    
    public List<Ankieta> findAll() {
        return ankietaRepository.findAll();
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

}