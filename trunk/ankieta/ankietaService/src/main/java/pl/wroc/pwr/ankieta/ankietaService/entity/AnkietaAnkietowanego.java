package pl.wroc.pwr.ankieta.ankietaService.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnkietaAnkietowanego {

    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ankietowany_id", nullable = false)
	private Ankietowany ankietowany;

	private Boolean czyUkonczona;

}