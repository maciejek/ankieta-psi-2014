package pl.wroc.pwr.ankieta.ankietaService.entity;

public enum DzienTygodnia {
    
	Poniedzia³ek("pn"), 
	Wtorek("wt"), 
	Œroda("œr"), 
	Czwartek("cz"), 
	Pi¹tek("pt"), 
	Sobota("sb"), 
	Niedziela("nd");
	
	String skrot;
	
	private DzienTygodnia(String skrot) {
	    this.skrot = skrot;
	}
	
	public String toString() {
	    return skrot;
	}	
	
}