package pl.wroc.pwr.ankieta.entity;

import java.util.*;

public class Ankieta {

	Audytor audytor;

	Collection<Pytanie> Pytania;

	Collection<Ankietowany> grupaAnkietowanych;

	Zajecia zajêcia;

	Collection<Uzytkownik> zainteresowani;

	private Integer id;

	private String tytul;

	private Date terminRozpoczecia;

	private int terminZakonczenia;

	private String komentarzDoWyniku;

}