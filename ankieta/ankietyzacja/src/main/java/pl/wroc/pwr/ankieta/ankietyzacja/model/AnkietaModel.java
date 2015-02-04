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