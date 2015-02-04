package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public abstract class Pytanie {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ankieta_id", nullable = false)
	private Ankieta ankieta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "szablon_id", nullable = false)
	private Szablon szablon;

	@OneToMany(mappedBy = "pytanie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Odpowiedz> odpowiedz;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String tresc;

}