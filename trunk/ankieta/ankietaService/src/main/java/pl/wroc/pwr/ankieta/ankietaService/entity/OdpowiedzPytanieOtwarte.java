package pl.wroc.pwr.ankieta.ankietaService.entity;

import javax.persistence.Entity;

@Entity
public class OdpowiedzPytanieOtwarte extends Odpowiedz {

	private String tresc;

    public String getTresc() {
        return tresc;
    }
    
    public OdpowiedzPytanieOtwarte() {
        super();
    }
    
    public OdpowiedzPytanieOtwarte(String tresc) {
        super();
        this.tresc = tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String toString() {
        return tresc;
    }

}