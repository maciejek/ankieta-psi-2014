package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ankieta {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "audytor_id", nullable = true)
	private Audytor audytor;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Pytanie> pytania;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Ankieta_Ankietowany", joinColumns = { 
            @JoinColumn(name = "ankieta_id", nullable = true, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "ankietowany_id", 
                    nullable = true, updatable = false) })
	private Collection<Ankietowany> grupaAnkietowanych;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zajecia_id", nullable = true)
	private Zajecia zajecia;

	@OneToMany
	@JoinTable(name = "Ankieta_Zainteresowany", joinColumns = { 
            @JoinColumn(name = "ankieta_id", nullable = true, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "zainteresowany_id", 
                    nullable = true, updatable = false) })
	private Collection<Uzytkownik> zainteresowani;
	
	@OneToMany(targetEntity=AnkietaAnkietowanego.class, mappedBy="ankieta", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Collection<AnkietaAnkietowanego> ankietyAnkietowanych;

	@Id
    @GeneratedValue
	private Integer id;

	private String tytul;

	private Date terminRozpoczecia;

	private Date terminZakonczenia;

	private String komentarzDoWyniku;

    public Audytor getAudytor() {
        return audytor;
    }

    public void setAudytor(Audytor audytor) {
        this.audytor = audytor;
    }

    public List<Pytanie> getPytania() {
        return pytania;
    }

    public void setPytania(List<Pytanie> pytania) {
        this.pytania = pytania;
    }

    public Collection<Ankietowany> getGrupaAnkietowanych() {
        return grupaAnkietowanych;
    }

    public void setGrupaAnkietowanych(Collection<Ankietowany> grupaAnkietowanych) {
        this.grupaAnkietowanych = grupaAnkietowanych;
    }

    public Zajecia getZajecia() {
        return zajecia;
    }

    public void setZajecia(Zajecia zajecia) {
        this.zajecia = zajecia;
    }

    public Collection<Uzytkownik> getZainteresowani() {
        return zainteresowani;
    }

    public void setZainteresowani(Collection<Uzytkownik> zainteresowani) {
        this.zainteresowani = zainteresowani;
    }

    public Integer getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Date getTerminRozpoczecia() {
        return terminRozpoczecia;
    }

    public void setTerminRozpoczecia(Date terminRozpoczecia) {
        this.terminRozpoczecia = terminRozpoczecia;
    }

    public Date getTerminZakonczenia() {
        return terminZakonczenia;
    }

    public void setTerminZakonczenia(Date terminZakonczenia) {
        this.terminZakonczenia = terminZakonczenia;
    }

    public String getKomentarzDoWyniku() {
        return komentarzDoWyniku;
    }

    public void setKomentarzDoWyniku(String komentarzDoWyniku) {
        this.komentarzDoWyniku = komentarzDoWyniku;
    }

    public Collection<AnkietaAnkietowanego> getAnkietyAnkietowanych() {
        return ankietyAnkietowanych;
    }

    public void setAnkietyAnkietowanych(
            Collection<AnkietaAnkietowanego> ankietyAnkietowanych) {
        this.ankietyAnkietowanych = ankietyAnkietowanych;
    }

}