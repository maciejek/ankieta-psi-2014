package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.Collection;

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
	private Collection<Zajecia> zajecia;

	private String nazwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Zajecia> getZajecia() {
        return zajecia;
    }

    public void setZajecia(Collection<Zajecia> zajecia) {
        this.zajecia = zajecia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}