package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Audytor extends Uzytkownik {

    @OneToMany(targetEntity=Ankieta.class, mappedBy="audytor", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Collection<Ankieta> ankiety;

    public Collection<Ankieta> getAnkiety() {
        return ankiety;
    }

    public void setAnkiety(Collection<Ankieta> ankiety) {
        this.ankiety = ankiety;
    }

}