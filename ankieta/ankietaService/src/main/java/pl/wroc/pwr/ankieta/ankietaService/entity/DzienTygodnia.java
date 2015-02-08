package pl.wroc.pwr.ankieta.ankietaService.entity;

public enum DzienTygodnia {
    
	Poniedzia�ek("pn"), 
	Wtorek("wt"), 
	�roda("�r"), 
	Czwartek("cz"), 
	Pi�tek("pt"), 
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