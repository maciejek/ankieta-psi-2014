package pl.wroc.pwr.ankieta.ankietyzacja.model;

import java.util.ArrayList;
import java.util.List;

public class WypelnianieAnkietyModel {

	private List<String> odpowiedzi;

	private Integer ankietaId;
	
	public WypelnianieAnkietyModel() {
	    odpowiedzi = new ArrayList<String>();
	    ankietaId = -1;
	}

    public List<String> getOdpowiedzi() {
        return odpowiedzi;
    }

    public void setOdpowiedzi(List<String> odpowiedzi) {
        this.odpowiedzi = odpowiedzi;
    }
    
    public String toString() {
        return odpowiedzi.toString();
    }

    public Integer getAnkietaId() {
        return ankietaId;
    }

    public void setAnkietaId(Integer ankietaId) {
        this.ankietaId = ankietaId;
    }
}