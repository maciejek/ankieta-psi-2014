package pl.wroc.pwr.ankieta.ankietaService.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WybranaOdpowiedz extends Odpowiedz {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wariant_id", nullable = false)
	private WariantOdpowiedzi wariantOdpowiedzi;

}