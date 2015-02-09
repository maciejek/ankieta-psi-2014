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
import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Audytor;
import pl.wroc.pwr.ankieta.ankietaService.entity.DzienTygodnia;
import pl.wroc.pwr.ankieta.ankietaService.entity.Kurs;
import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.entity.Otwarte;
import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
import pl.wroc.pwr.ankieta.ankietaService.entity.WariantOdpowiedzi;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zamkniete;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietaRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.AnkietowanyRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.AudytorRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.KursRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.NauczycielRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.PytanieRepository;
import pl.wroc.pwr.ankieta.ankietaService.repository.SzablonRepository;
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
    private AnkietowanyRepository ankietowanyRepository;
    
    @Autowired
    private NauczycielRepository nauczycielRepository;
    
    @Autowired
    private ZajeciaRepository zajeciaRepository;
    
    @Autowired
    private KursRepository kursRepository;
    @Autowired
    private SzablonRepository szablonRepository;
    
    @Autowired
    private AnkietaRepository ankietaRepository;
    
    @Autowired
    private PytanieRepository pytanieRepository;

    @PostConstruct
    public void init() {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        if (uzytkownikRepository.findByEmail("jan.kowalski@pwr.edu.pl") == null) {
        
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
            zajecia1.setDzienTygodnia(DzienTygodnia.Sroda);
            zajecia1.setGodzinaRozpoczecia("17:05");
            zajecia1.setGodzinaZakonczenia("18:45");
            zajecia1.setKurs(kurs1);
            ArrayList<Nauczyciel> nauczycieleZajec1 = new ArrayList<Nauczyciel>();
            nauczycieleZajec1.add(nauczyciel1);
            zajecia1.setNauczyciele(nauczycieleZajec1);
            zajeciaRepository.save(zajecia1);
            
            Zajecia zajecia2 = new Zajecia();
            zajecia2.setDzienTygodnia(DzienTygodnia.Sroda);
            zajecia2.setGodzinaRozpoczecia("18:55");
            zajecia2.setGodzinaZakonczenia("20:35");
            zajecia2.setKurs(kurs1);
            ArrayList<Nauczyciel> nauczycieleZajec2 = new ArrayList<Nauczyciel>();
            nauczycieleZajec2.add(nauczyciel1);
            zajecia2.setNauczyciele(nauczycieleZajec2);
            zajeciaRepository.save(zajecia2);
            
            Zajecia zajecia3 = new Zajecia();
            zajecia3.setDzienTygodnia(DzienTygodnia.Czwartek);
            zajecia3.setGodzinaRozpoczecia("18:55");
            zajecia3.setGodzinaZakonczenia("20:35");
            zajecia3.setKurs(kurs2);
            ArrayList<Nauczyciel> nauczycieleZajec3 = new ArrayList<Nauczyciel>();
            nauczycieleZajec3.add(nauczyciel1);
            zajecia3.setNauczyciele(nauczycieleZajec3);
            zajeciaRepository.save(zajecia3);
            
            Zajecia zajecia4 = new Zajecia();
            zajecia4.setDzienTygodnia(DzienTygodnia.Piatek);
            zajecia4.setGodzinaRozpoczecia("07:30");
            zajecia4.setGodzinaZakonczenia("09:00");
            zajecia4.setKurs(kurs2);
            ArrayList<Nauczyciel> nauczycieleZajec4 = new ArrayList<Nauczyciel>();
            nauczycieleZajec4.add(nauczyciel1);
            zajecia4.setNauczyciele(nauczycieleZajec4);
            zajeciaRepository.save(zajecia4);
            
            Zajecia zajecia5 = new Zajecia();
            zajecia5.setDzienTygodnia(DzienTygodnia.Piatek);
            zajecia5.setGodzinaRozpoczecia("09:15");
            zajecia5.setGodzinaZakonczenia("11:00");
            zajecia5.setKurs(kurs2);
            ArrayList<Nauczyciel> nauczycieleZajec5 = new ArrayList<Nauczyciel>();
            nauczycieleZajec5.add(nauczyciel1);
            zajecia5.setNauczyciele(nauczycieleZajec5);
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
            zajecia6.setDzienTygodnia(DzienTygodnia.Poniedzialek);
            zajecia6.setGodzinaRozpoczecia("09:15");
            zajecia6.setGodzinaZakonczenia("11:00");
            zajecia6.setKurs(kurs2);
            ArrayList<Nauczyciel> nauczycieleZajec6 = new ArrayList<Nauczyciel>();
            nauczycieleZajec6.add(nauczyciel2);
            zajecia6.setNauczyciele(nauczycieleZajec6);
            zajeciaRepository.save(zajecia6);
            
            ArrayList<Zajecia> zajeciaNauczyciela2 = new ArrayList<Zajecia>();
            zajeciaNauczyciela2.add(zajecia6);
            nauczyciel2.setZajecia(zajeciaNauczyciela2);
            nauczycielRepository.save(nauczyciel2);
            
            ArrayList<Zajecia> zajeciaKursu1 = new ArrayList<Zajecia>();
            zajeciaKursu1.add(zajecia1);
            zajeciaKursu1.add(zajecia2);
            kurs1.setZajecia(zajeciaKursu1);
            kursRepository.save(kurs1);
            
            ArrayList<Zajecia> zajeciaKursu2 = new ArrayList<Zajecia>();
            zajeciaKursu2.add(zajecia3);
            zajeciaKursu2.add(zajecia4);
            zajeciaKursu2.add(zajecia5);
            zajeciaKursu2.add(zajecia6);
            kurs2.setZajecia(zajeciaKursu2);
            kursRepository.save(kurs2);
            
            Ankieta ankieta1 = new Ankieta();
            ankieta1.setAudytor(audytor1);
            ankieta1.setTerminRozpoczecia(new Date(1391872980000L));
            ankieta1.setTerminZakonczenia(new Date(1523408800000L));
            ankieta1.setTytul("tytul roboczy");
            ankieta1.setZajecia(zajecia1);
            

            Pytanie pytanie1 = new Otwarte();
            pytanie1.setTresc("tresc1");
            pytanie1.setAnkieta(ankieta1);
            
            Zamkniete pytanie2 = new Zamkniete();
            pytanie2.setTresc("tresc2");
            pytanie2.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie2, false, "wariant1"));
            pytanie2.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie2, false, "wariant2"));
            pytanie2.addWariantOdpowiedzi(new WariantOdpowiedzi(pytanie2, false, "wariant3"));
            pytanie2.setAnkieta(ankieta1);
            
            Zamkniete pytanie3 = new Zamkniete();
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
            
            ArrayList<Ankieta> ankiety = new ArrayList<Ankieta>();
            ankiety.add(ankieta1);
            
            ankietaRepository.save(ankieta1);
            
            ArrayList<Zajecia> zajeciaAnkietowanego1 = new ArrayList<Zajecia>();
            zajeciaAnkietowanego1.add(zajecia1);
            
            Ankietowany ankietowany1 = new Ankietowany();
            ankietowany1.setEmail("183680@student.pwr.edu.pl");
            ankietowany1.setHaslo(encoder.encode("12345"));
            ankietowany1.setZajecia(zajeciaAnkietowanego1);
            ankietowanyRepository.save(ankietowany1);
            
            Ankietowany ankietowany2 = new Ankietowany();
            ankietowany2.setEmail("183614@student.pwr.edu.pl");
            ankietowany2.setHaslo(encoder.encode("12345"));
            ankietowany2.setZajecia(zajeciaAnkietowanego1);
            ankietowanyRepository.save(ankietowany2);
            
            Ankietowany ankietowany3 = new Ankietowany();
            ankietowany3.setEmail("183695@student.pwr.edu.pl");
            ankietowany3.setHaslo(encoder.encode("12345"));
            ankietowany3.setZajecia(zajeciaAnkietowanego1);
            ankietowanyRepository.save(ankietowany3);
            
            ArrayList<Ankietowany> ankietowaniZajec1 = new ArrayList<Ankietowany>();
            ankietowaniZajec1.add(ankietowany1);
            ankietowaniZajec1.add(ankietowany2);
            ankietowaniZajec1.add(ankietowany3);
            zajecia1.setAnkietowani(ankietowaniZajec1);
            zajeciaRepository.save(zajecia1);
            
            ArrayList<Zajecia> zajeciaAnkietowanego2 = new ArrayList<Zajecia>();
            zajeciaAnkietowanego2.add(zajecia2);
            
            Ankietowany ankietowany4 = new Ankietowany();
            ankietowany4.setEmail("183727@student.pwr.edu.pl");
            ankietowany4.setHaslo(encoder.encode("12345"));
            ankietowany4.setZajecia(zajeciaAnkietowanego2);
            ankietowanyRepository.save(ankietowany4);
            
            Ankietowany ankietowany5 = new Ankietowany();
            ankietowany5.setEmail("183681@student.pwr.edu.pl");
            ankietowany5.setHaslo(encoder.encode("12345"));
            ankietowany5.setZajecia(zajeciaAnkietowanego2);
            ankietowanyRepository.save(ankietowany5);
            
            Ankietowany ankietowany6 = new Ankietowany();
            ankietowany6.setEmail("183619@student.pwr.edu.pl");
            ankietowany6.setHaslo(encoder.encode("12345"));
            ankietowany6.setZajecia(zajeciaAnkietowanego2);
            ankietowanyRepository.save(ankietowany6);
            
            ArrayList<Ankietowany> ankietowaniZajec2 = new ArrayList<Ankietowany>();
            ankietowaniZajec2.add(ankietowany4);
            ankietowaniZajec2.add(ankietowany5);
            ankietowaniZajec2.add(ankietowany6);
            zajecia2.setAnkietowani(ankietowaniZajec2);
            zajeciaRepository.save(zajecia2);
            
            Ankietowany ankietowany7 = new Ankietowany();
            ankietowany7.setEmail("ankietowany@pwr.wroc.pl");
            ankietowany7.setHaslo(encoder.encode("ankietowany"));
            ankietowany7.setAnkiety(ankiety);

            ArrayList<Ankietowany> grupaAnkietowanych = new ArrayList<Ankietowany>();
            grupaAnkietowanych.add(ankietowany7);
            ankieta1.setGrupaAnkietowanych(grupaAnkietowanych);
            ankietowanyRepository.save(ankietowany7);
            
            Szablon szablon1 = new Szablon();
            szablon1.setNazwa("Przyk³adowy szablon 1");
            szablonRepository.save(szablon1);
            
            Szablon szablon2 = new Szablon();
            szablon2.setNazwa("Przyk³adowy szablon 2");
            szablonRepository.save(szablon2);
        }
        
    }
}
