package pl.wroc.pwr.ankieta.entity;

import java.util.*;

public class Nauczyciel extends Uzytkownik {

	KierownikJednostki przełożony;

	Collection<Zajecia> zajecia;

	private String nazwisko;

	private String imie;

	private String tytulNaukowy;

}