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

    public Collection<AnkietaAnkietowanego> getAnkietaAnkietowanego() {
        return ankietaAnkietowanego;
    }

    public void setAnkietaAnkietowanego(
            Collection<AnkietaAnkietowanego> ankietaAnkietowanego) {
        this.ankietaAnkietowanego = ankietaAnkietowanego;
    }

    public Collection<Ankieta> getAnkiety() {
        return ankiety;
    }

    public void setAnkiety(Collection<Ankieta> ankiety) {
        this.ankiety = ankiety;
    }

    public Collection<Zajecia> getZajêcia() {
        return zajêcia;
    }

    public void setZajêcia(Collection<Zajecia> zajêcia) {
        this.zajêcia = zajêcia;
    }
    
    public void addAnkietaAnkietowanego(AnkietaAnkietowanego wypelnionaAnkieta) {
        this.ankietaAnkietowanego.add(wypelnionaAnkieta);
    }

}