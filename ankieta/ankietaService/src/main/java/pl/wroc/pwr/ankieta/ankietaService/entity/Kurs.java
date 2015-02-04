package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kurs {

    @Id
    @GeneratedValue
    private Integer id;
    
    @OneToMany(targetEntity=Zajecia.class, mappedBy="kurs", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Zajecia> zaj�cia;

	private String nazwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Zajecia> getZaj�cia() {
        return zaj�cia;
    }

    public void setZaj�cia(Collection<Zajecia> zaj�cia) {
        this.zaj�cia = zaj�cia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}