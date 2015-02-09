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
public class WariantOdpowiedzi {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pytanie_id", nullable = false)
	private Zamkniete pytanieZamkniete;
    
    @OneToMany(mappedBy = "wariantOdpowiedzi", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<WybranaOdpowiedz> wybraneOdpowiedzi;

	private Boolean czyLiczbowy;

	private String tresc;
	
	public WariantOdpowiedzi() {}

    public WariantOdpowiedzi(Zamkniete pytanieZamkniete,
            Boolean czyLiczbowy, String tresc) {
        super();
        this.pytanieZamkniete = pytanieZamkniete;
        this.czyLiczbowy = czyLiczbowy;
        this.tresc = tresc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Zamkniete getPytanieZamkniete() {
        return pytanieZamkniete;
    }

    public void setPytanieZamkniete(Zamkniete pytanieZamkniete) {
        this.pytanieZamkniete = pytanieZamkniete;
    }

    public Collection<WybranaOdpowiedz> getWybraneOdpowiedzi() {
        return wybraneOdpowiedzi;
    }

    public void setWybraneOdpowiedzi(Collection<WybranaOdpowiedz> wybraneOdpowiedzi) {
        this.wybraneOdpowiedzi = wybraneOdpowiedzi;
    }

    public Boolean getCzyLiczbowy() {
        return czyLiczbowy;
    }

    public void setCzyLiczbowy(Boolean czyLiczbowy) {
        this.czyLiczbowy = czyLiczbowy;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
    
    public String toString() {
        return tresc;
    }

}