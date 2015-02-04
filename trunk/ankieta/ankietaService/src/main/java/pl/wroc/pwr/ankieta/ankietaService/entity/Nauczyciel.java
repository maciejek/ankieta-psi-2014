package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Nauczyciel extends Uzytkownik {

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "nauczyciele")
	private Collection<Zajecia> zajecia;

	private String nazwisko;

	private String imie;

	private String tytulNaukowy;

    public Collection<Zajecia> getZajecia() {
        return zajecia;
    }

    public void setZajecia(Collection<Zajecia> zajecia) {
        this.zajecia = zajecia;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getTytulNaukowy() {
        return tytulNaukowy;
    }

    public void setTytulNaukowy(String tytulNaukowy) {
        this.tytulNaukowy = tytulNaukowy;
    }

}