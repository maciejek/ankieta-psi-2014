package pl.wroc.pwr.ankieta.ankietyzacja.model;

import java.util.ArrayList;
import java.util.List;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;

public class WypelnianieAnkietyModel {

	private List<String> odpowiedziOtwarte;

	private List<String> odpowiedziZamkniete;  //TODO:Intidzery
	
	private Integer ankietaId;
	
	public WypelnianieAnkietyModel() {
	    odpowiedziOtwarte = new ArrayList<String>();
	    odpowiedziZamkniete = new ArrayList<String>();
	    ankietaId = -1;
	}

    public List<String> getOdpowiedziOtwarte() {
        return odpowiedziOtwarte;
    }

    public void setOdpowiedziOtwarte(List<String> odpowiedziOtwarte) {
        this.odpowiedziOtwarte = odpowiedziOtwarte;
    }

    public List<String> getOdpowiedziZamkniete() {
        return odpowiedziZamkniete;
    }

    public void setOdpowiedziZamkniete(List<String> odpowiedziZamkniete) {
        this.odpowiedziZamkniete = odpowiedziZamkniete;
    }
    
    public String toString() {
        return "O:" + odpowiedziOtwarte.toString() + "Z:" + odpowiedziZamkniete.toString();
    }

    public Integer getAnkietaId() {
        return ankietaId;
    }

    public void setAnkietaId(Integer ankietaId) {
        this.ankietaId = ankietaId;
    }
}