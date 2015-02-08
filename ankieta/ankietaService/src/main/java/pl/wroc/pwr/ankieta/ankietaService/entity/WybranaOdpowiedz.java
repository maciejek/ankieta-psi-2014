package pl.wroc.pwr.ankieta.ankietaService.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WybranaOdpowiedz extends Odpowiedz {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wariant_id", nullable = true)//TODO:maciek - false zmienione na true
	private WariantOdpowiedzi wariantOdpowiedzi;
    
    public WybranaOdpowiedz() {}

    public WybranaOdpowiedz(WariantOdpowiedzi wariantOdpowiedzi) {
        super();
        this.wariantOdpowiedzi = wariantOdpowiedzi;
    }

    public WariantOdpowiedzi getWariantOdpowiedzi() {
        return wariantOdpowiedzi;
    }

    public void setWariantOdpowiedzi(WariantOdpowiedzi wariantOdpowiedzi) {
        this.wariantOdpowiedzi = wariantOdpowiedzi;
    }

}