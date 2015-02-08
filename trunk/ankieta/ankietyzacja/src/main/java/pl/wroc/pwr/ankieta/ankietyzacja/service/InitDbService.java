package pl.wroc.pwr.ankieta.ankietyzacja.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;
import pl.wroc.pwr.ankieta.ankietaService.entity.Audytor;
import pl.wroc.pwr.ankieta.ankietaService.entity.DzienTygodnia;
import pl.wroc.pwr.ankieta.ankietaService.entity.Kurs;
import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.entity.Otwarte;
import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
import pl.wroc.pwr.ankieta.ankietaService.entity.WariantOdpowiedzi;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zamkniête;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.AudytorRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.KursRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.NauczycielRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.PytanieRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.UzytkownikRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.ZajeciaRepository;

@Service
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public class InitDbService {
    
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    
    @Autowired
    private AudytorRepository audytorRepository;
    
    @Autowired
    private NauczycielRepository nauczycielRepository;
    
    @Autowired
    private ZajeciaRepository zajeciaRepository;
    
    @Autowired
    private KursRepository kursRepository;
    
    @Autowired
    private AnkietaRepository ankietaRepository;
    
    @Autowired
    private PytanieRepository pytanieRepository;

    @PostConstruct
    public void init() {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
       // if (uzytkownikRepository.findByEmail("jan.kowalski@pwr.edu.pl") == null) {
        
            Audytor audytor1 = new Audytor();
            audytor1.setEmail("jan.kowalski@pwr.edu.pl");
            audytor1.setHaslo(encoder.encode("qaz"));
            audytorRepository.save(audytor1);
            
            Nauczyciel nauczyciel1 = new Nauczyciel();
            nauczyciel1.setEmail("bogumila.hnatkowska@pwr.edu.pl");
            nauczyciel1.setHaslo(encoder.encode("12345"));
            nauczyciel1.setImie("Bogumi³a");
            nauczyciel1.setNazwisko("Hnatkowska");
            nauczyciel1.setTytulNaukowy("dr in¿.");
            nauczycielRepository.save(nauczyciel1);
            
            Kurs kurs1 = new Kurs();
            kurs1.setNazwa("Projektowanie systemów informatycznych");
            kursRepository.save(kurs1);
            
            Kurs kurs2 = new Kurs();
            kurs2.setNazwa("Projektowanie oprogramowania");
            kursRepository.save(kurs2);
            
            Zajecia zajecia1 = new Zajecia();
            zajecia1.setDzienTygodnia(DzienTygodnia.Œroda);
            zajecia1.setGodzinaRozpoczecia("17:05");
            zajecia1.setGodzinaZakonczenia("18:45");
            zajecia1.setKurs(kurs1);
            zajeciaRepository.save(zajecia1);
            
            Zajecia zajecia2 = new Zajecia();
            zajecia2.setDzienTygodnia(DzienTygodnia.Œroda);
            zajecia2.setGodzinaRozpoczecia("18:55");
            zajecia2.setGodzinaZakonczenia("20:35");
            zajecia2.setKurs(kurs1);
            zajeciaRepository.save(zajecia2);
            
            Zajecia zajecia3 = new Zajecia();
            zajecia3.setDzienTygodnia(DzienTygodnia.Czwartek);
            zajecia3.setGodzinaRozpoczecia("18:55");
            zajecia3.setGodzinaZakonczenia("20:35");
            zajecia3.setKurs(kurs2);
            zajeciaRepository.save(zajecia3);
            
            Zajecia zajecia4 = new Zajecia();
            zajecia4.setDzienTygodnia(DzienTygodnia.Pi¹tek);
            zajecia4.setGodzinaRozpoczecia("07:30");
            zajecia4.setGodzinaZakonczenia("09:00");
            zajecia4.setKurs(kurs2);
            zajeciaRepository.save(zajecia4);
            
            Zajecia zajecia5 = new Zajecia();
            zajecia5.setDzienTygodnia(DzienTygodnia.Pi¹tek);
            zajecia5.setGodzinaRozpoczecia("09:15");
            zajecia5.setGodzinaZakonczenia("11:00");
            zajecia5.setKurs(kurs2);
            zajeciaRepository.save(zajecia5);
    
            ArrayList<Zajecia> zajeciaNauczyciela1 = new ArrayList<Zajecia>();
            zajeciaNauczyciela1.add(zajecia1);
            zajeciaNauczyciela1.add(zajecia2);
            zajeciaNauczyciela1.add(zajecia3);
            zajeciaNauczyciela1.add(zajecia4);
            zajeciaNauczyciela1.add(zajecia5);
            nauczyciel1.setZajecia(zajeciaNauczyciela1);
            nauczycielRepository.save(nauczyciel1);
            
            Nauczyciel nauczyciel2 = new Nauczyciel();
            nauczyciel2.setEmail("lech.madeyski@pwr.edu.pl");
            nauczyciel2.setHaslo(encoder.encode("12345"));
            nauczyciel2.setImie("Lech");
            nauczyciel2.setNazwisko("Madeyski");
            nauczyciel2.setTytulNaukowy("prof.");
            nauczycielRepository.save(nauczyciel2);
            
            Zajecia zajecia6 = new Zajecia();
            zajecia6.setDzienTygodnia(DzienTygodnia.Poniedzia³ek);
            zajecia6.setGodzinaRozpoczecia("09:15");
            zajecia6.setGodzinaZakonczenia("11:00");
            zajecia6.setKurs(kurs2);
            zajeciaRepository.save(zajecia6);
            
            ArrayList<Zajecia> zajeciaNauczyciela2 = new ArrayList<Zajecia>();
            zajeciaNauczyciela2.add(zajecia6);
            nauczyciel2.setZajecia(zajeciaNauczyciela2);
            nauczycielRepository.save(nauczyciel2);
            
            ArrayList<Zajecia> zajeciaKursu1 = new ArrayList<Zajecia>();
            zajeciaKursu1.add(zajecia1);
            zajeciaKursu1.add(zajecia2);
            kurs1.setZajêcia(zajeciaKursu1);
            kursRepository.save(kurs1);
            
            ArrayList<Zajecia> zajeciaKursu2 = new ArrayList<Zajecia>();
            zajeciaKursu2.add(zajecia3);
            zajeciaKursu2.add(zajecia4);
            zajeciaKursu2.add(zajecia5);
            zajeciaKursu2.add(zajecia6);
            kurs2.setZajêcia(zajeciaKursu2);
            kursRepository.save(kurs2);
            
            Ankieta ankieta1 = new Ankieta();
            ankieta1.setAudytor(audytor1);
            ankieta1.setTerminRozpoczecia(new Date());
            ankieta1.setTerminZakonczenia(new Date());
            ankieta1.setTytul("tytul roboczy");
            ankieta1.setZajêcia(zajecia1);
          //  ankietaRepository.save(ankieta1);

            //TODO:MACIEK - CO Z TYM?
            Pytanie pytanie1 = new Otwarte();
            pytanie1.setTresc("tresc1");
            pytanie1.setAnkieta(ankieta1);
            
            Zamkniête pytanie2 = new Zamkniête();
            pytanie2.setTresc("tresc2");
            pytanie2.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie2, false, "wariant1"));
            pytanie2.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie2, false, "wariant2"));
            pytanie2.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie2, false, "wariant3"));
            pytanie2.setAnkieta(ankieta1);
            
            Zamkniête pytanie3 = new Zamkniête();
            pytanie3.setTresc("tresc2");
            pytanie3.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie3, true, "1"));
            pytanie3.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie3, true, "2"));
            pytanie3.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie3, true, "3"));
            pytanie3.setAnkieta(ankieta1);
            
            Pytanie pytanie4 = new Otwarte();
            pytanie4.setTresc("tresc4");
            pytanie4.setAnkieta(ankieta1);
            
            ArrayList<Pytanie> pytania = new ArrayList<Pytanie>();
            pytania.add(pytanie1);
            pytania.add(pytanie2);
            pytania.add(pytanie3);
            pytania.add(pytanie4);
            ankieta1.setPytania(pytania);
            
            ankietaRepository.save(ankieta1);
            pytanieRepository.save(pytanie1);
            pytanieRepository.save(pytanie2);
            };
       // }
        
    
}
