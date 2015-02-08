package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Szablon {
    
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "szablon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Pytanie> pytaniaSkladowe;

	private String nazwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Pytanie> getPytaniaSkladowe() {
        return pytaniaSkladowe;
    }

    public void setPytaniaSkladowe(Collection<Pytanie> pytaniaSkladowe) {
        this.pytaniaSkladowe = pytaniaSkladowe;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
	
	

}