package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AnkietaAnkietowanego {

    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ankietowany_id", nullable = false)
	private Ankietowany ankietowany;

    private Boolean czyUkonczona;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Odpowiedz> odpowiedzi;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ankieta_id", nullable = false)
	private Ankieta ankieta;
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ankietowany getAnkietowany() {
        return ankietowany;
    }

    public void setAnkietowany(Ankietowany ankietowany) {
        this.ankietowany = ankietowany;
    }

    public Boolean getCzyUkonczona() {
        return czyUkonczona;
    }

    public void setCzyUkonczona(Boolean czyUkonczona) {
        this.czyUkonczona = czyUkonczona;
    }

    public Collection<Odpowiedz> getOdpowiedzi() {
        return odpowiedzi;
    }

    public void setOdpowiedzi(Collection<Odpowiedz> odpowiedzi) {
        this.odpowiedzi = odpowiedzi;
    }

    public Ankieta getAnkieta() {
        return ankieta;
    }

    public void setAnkieta(Ankieta ankieta) {
        this.ankieta = ankieta;
    }
    
    public String toString() {
        return odpowiedzi.toString();
    }

}