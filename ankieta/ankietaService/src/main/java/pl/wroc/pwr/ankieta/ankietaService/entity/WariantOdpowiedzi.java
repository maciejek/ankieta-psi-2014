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
	private Zamkniête pytanieZamkniete;
    
    @OneToMany(mappedBy = "wariantOdpowiedzi", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<WybranaOdpowiedz> wybraneOdpowiedzi;

	private Boolean czyLiczbowy;

	private String tresc;

}