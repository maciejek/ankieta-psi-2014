package pl.wroc.pwr.ankieta.ankietyzacja.model;

import java.util.List;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;

public class AnkietaModel {

    private String tytul;

	private List<Nauczyciel> nauczyciele;

	private Nauczyciel nauczyciel;
	
	private Zajecia zajecia;

    private List<Zajecia> zajeciaDlaNauczyciela;

	private List<Szablon> szablony;

	private List<Pytanie> pytaniaDlaSzablonu;

	private List<Pytanie> pytania;

	private List<Ankietowany> ankietowani;

	private List<Ankietowany> ankietowaniDlaZajec;

    public Zajecia getZajecia() {
        return zajecia;
    }

    public void setZajecia(Zajecia zajecia) {
        this.zajecia = zajecia;
    }
    
    public Nauczyciel getNauczyciel() {
		return this.nauczyciel;
	}

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public List<Nauczyciel> getNauczyciele() {
        return nauczyciele;
    }

    public void setNauczyciele(List<Nauczyciel> nauczyciele) {
        this.nauczyciele = nauczyciele;
    }

    public List<Zajecia> getZajeciaDlaNauczyciela() {
        return zajeciaDlaNauczyciela;
    }

    public void setZajeciaDlaNauczyciela(List<Zajecia> zajeciaDlaNauczyciela) {
        this.zajeciaDlaNauczyciela = zajeciaDlaNauczyciela;
    }

    public List<Szablon> getSzablony() {
        return szablony;
    }

    public void setSzablony(List<Szablon> szablony) {
        this.szablony = szablony;
    }

    public List<Pytanie> getPytaniaDlaSzablonu() {
        return pytaniaDlaSzablonu;
    }

    public void setPytaniaDlaSzablonu(List<Pytanie> pytaniaDlaSzablonu) {
        this.pytaniaDlaSzablonu = pytaniaDlaSzablonu;
    }

    public List<Pytanie> getPytania() {
        return pytania;
    }

    public void setPytania(List<Pytanie> pytania) {
        this.pytania = pytania;
    }

    public List<Ankietowany> getAnkietowani() {
        return ankietowani;
    }

    public void setAnkietowani(List<Ankietowany> ankietowani) {
        this.ankietowani = ankietowani;
    }

    public List<Ankietowany> getAnkietowaniDlaZajec() {
        return ankietowaniDlaZajec;
    }

    public void setAnkietowaniDlaZajec(List<Ankietowany> ankietowaniDlaZajec) {
        this.ankietowaniDlaZajec = ankietowaniDlaZajec;
    }

    public void setNauczyciel(Nauczyciel nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

}