package pl.wroc.pwr.ankieta.ankietaService.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class Odpowiedz {

    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pytanie_id", nullable = false)
	private Pytanie pytanie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pytanie getPytanie() {
        return pytanie;
    }

    public void setPytanie(Pytanie pytanie) {
        this.pytanie = pytanie;
    }

}