package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Zamkniete extends Pytanie {

    @OneToMany(mappedBy = "pytanieZamkniete", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<WariantOdpowiedzi> wariantyOdpowiedzi = new LinkedList<WariantOdpowiedzi>();
    
    public void addWariantOdpowiedzi(WariantOdpowiedzi wariantOdpowiedzi) {
        wariantyOdpowiedzi.add(wariantOdpowiedzi);
    }

    public Collection<WariantOdpowiedzi> getWariantyOdpowiedzi() {
        return wariantyOdpowiedzi;
    }

    public void setWariantyOdpowiedzi(
            Collection<WariantOdpowiedzi> wariantyOdpowiedzi) {
        this.wariantyOdpowiedzi = wariantyOdpowiedzi;
    }

}