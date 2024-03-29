package pl.wroc.pwr.ankieta.model;

import java.util.List;

import pl.wroc.pwr.ankieta.entity.Ankietowany;
import pl.wroc.pwr.ankieta.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.entity.Pytanie;
import pl.wroc.pwr.ankieta.entity.Szablon;
import pl.wroc.pwr.ankieta.entity.Zajecia;

public class AnkietaModel {

	private String tytul;

	private List<Nauczyciel> nauczyciele;

	private Nauczyciel nauczyciel;

	private List<Zajecia> zajeciaDlaNauczyciela;

	private List<Szablon> szablony;

	private List<Pytanie> pytaniaDlaSzablonu;

	private List<Pytanie> pytania;

	private List<Ankietowany> ankietowani;

	private List<Ankietowany> ankietowaniDlaZajec;

	public Nauczyciel getNauczyciel() {
		return this.nauczyciel;
	}

}