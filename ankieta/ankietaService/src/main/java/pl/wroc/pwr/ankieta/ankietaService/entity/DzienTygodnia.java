package pl.wroc.pwr.ankieta.ankietaService.entity;

public enum DzienTygodnia {
    
	Poniedzialek("pn"), 
	Wtorek("wt"), 
	Sroda("sr"), 
	Czwartek("cz"), 
	Piatek("pt"), 
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