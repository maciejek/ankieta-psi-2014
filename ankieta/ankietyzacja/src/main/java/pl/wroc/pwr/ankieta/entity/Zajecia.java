package pl.wroc.pwr.ankieta.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Zajecia {
    
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Zajecia_Uzytkownik", joinColumns = { 
            @JoinColumn(name = "zajecia_id", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "ankietowany_id", 
                    nullable = false, updatable = false) })
	private Collection<Ankietowany> ankietowani;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Zajecia_Nauczyciel", joinColumns = { 
            @JoinColumn(name = "zajecia_id", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "nauczyciel_id", 
                    nullable = false, updatable = false) })
	private Collection<Nauczyciel> nauczyciele;

	@OneToMany(mappedBy = "zajêcia", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Ankieta> ankiety;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kurs_id", nullable = false)
	private Kurs kurs;

	private DzienTygodnia dzienTygodnia;

	private String godzinaRozpoczecia;

	private String godzinaZakonczenia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Ankietowany> getAnkietowani() {
        return ankietowani;
    }

    public void setAnkietowani(Collection<Ankietowany> ankietowani) {
        this.ankietowani = ankietowani;
    }

    public Collection<Nauczyciel> getNauczyciele() {
        return nauczyciele;
    }

    public void setNauczyciele(Collection<Nauczyciel> nauczyciele) {
        this.nauczyciele = nauczyciele;
    }

    public Collection<Ankieta> getAnkiety() {
        return ankiety;
    }

    public void setAnkiety(Collection<Ankieta> ankiety) {
        this.ankiety = ankiety;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public DzienTygodnia getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(DzienTygodnia dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    public String getGodzinaRozpoczecia() {
        return godzinaRozpoczecia;
    }

    public void setGodzinaRozpoczecia(String godzinaRozpoczecia) {
        this.godzinaRozpoczecia = godzinaRozpoczecia;
    }

    public String getGodzinaZakonczenia() {
        return godzinaZakonczenia;
    }

    public void setGodzinaZakonczenia(String godzinaZakonczenia) {
        this.godzinaZakonczenia = godzinaZakonczenia;
    }

}