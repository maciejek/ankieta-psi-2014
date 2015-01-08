package pl.wroc.pwr.ankieta.entity;

import java.util.*;

public abstract class Pytanie {

	Ankieta ankieta;

	Szablon szablon;

	Collection<Odpowiedz> odpowiedz;

	private String tresc;

}