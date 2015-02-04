package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Ankietowany extends Uzytkownik {

    @OneToMany(targetEntity=AnkietaAnkietowanego.class, mappedBy="ankietowany", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<AnkietaAnkietowanego> ankietaAnkietowanego;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "grupaAnkietowanych")
    private Collection<Ankieta> ankiety;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "ankietowani")
	private Collection<Zajecia> zajêcia;

}