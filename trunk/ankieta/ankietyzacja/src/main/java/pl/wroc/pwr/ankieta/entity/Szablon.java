package pl.wroc.pwr.ankieta.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Szablon {
    
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "szablon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Pytanie> pytaniaSkladowe;

	private String nazwa;

}