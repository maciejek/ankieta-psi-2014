package pl.wroc.pwr.ankieta.entity;

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
    @JoinColumn(name = "audytor_id", nullable = false)
	private Audytor audytor;

    @OneToMany(mappedBy = "szablon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Pytanie> Pytania;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Ankieta_Ankietowany", joinColumns = { 
            @JoinColumn(name = "ankieta_id", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "ankietowany_id", 
                    nullable = false, updatable = false) })
	private Collection<Ankietowany> grupaAnkietowanych;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zajecia_id", nullable = false)
	private Zajecia zajêcia;

	@OneToMany
	@JoinTable(name = "Ankieta_Zainteresowany", joinColumns = { 
            @JoinColumn(name = "ankieta_id", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "zainteresowany_id", 
                    nullable = false, updatable = false) })
	private Collection<Uzytkownik> zainteresowani;

	@Id
    @GeneratedValue
	private Integer id;

	private String tytul;

	private Date terminRozpoczecia;

	private int terminZakonczenia;

	private String komentarzDoWyniku;

}