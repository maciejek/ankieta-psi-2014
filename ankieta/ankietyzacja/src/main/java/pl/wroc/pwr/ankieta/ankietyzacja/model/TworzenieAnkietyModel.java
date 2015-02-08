package pl.wroc.pwr.ankieta.ankietyzacja.model;

import java.util.List;

public class TworzenieAnkietyModel {

    private Integer idNauczyciela;
    
    private Integer idZajec;

    private String tytul;
    
    private List<String> pytania;
    
    private String grupaAnkietowanych;
    
    public Integer getIdNauczyciela() {
        return idNauczyciela;
    }

    public void setIdNauczyciela(Integer idNauczyciela) {
        this.idNauczyciela = idNauczyciela;
    }

    public Integer getIdZajec() {
        return idZajec;
    }

    public void setIdZajec(Integer idZajec) {
        this.idZajec = idZajec;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public List<String> getPytania() {
        return pytania;
    }

    public void setPytania(List<String> pytania) {
        this.pytania = pytania;
    }
    
    public String getGrupaAnkietowanych() {
        return grupaAnkietowanych;
    }

    public void setGrupaAnkietowanych(String grupaAnkietowanych) {
        this.grupaAnkietowanych = grupaAnkietowanych;
    }

    public String toString() {
        return idNauczyciela + " | " + tytul + " | " + idZajec + " | " + pytania.toString();
    }

}
