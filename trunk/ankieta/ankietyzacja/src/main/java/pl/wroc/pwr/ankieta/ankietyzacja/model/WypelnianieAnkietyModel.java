package pl.wroc.pwr.ankieta.ankietyzacja.model;

import java.util.ArrayList;
import java.util.List;

public class WypelnianieAnkietyModel {

	private List<String> odpowiedziOtwarte;

	private List<String> odpowiedziZamkniete;  //TODO:Intidzery
	
	public WypelnianieAnkietyModel() {
	    odpowiedziOtwarte = new ArrayList<String>();
	    odpowiedziZamkniete = new ArrayList<String>();
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

}