package pl.wroc.pwr.ankieta.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Synonim {
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nadrzedny_id", nullable = false)
    private Synonim synonimNadrzedny;

    @OneToMany(mappedBy="synonimNadrzedny", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Collection<Synonim> synonimy;

    @Id
    @GeneratedValue
    private Integer id;

	private String slowo;

}