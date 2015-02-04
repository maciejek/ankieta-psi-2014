package pl.wroc.pwr.ankieta.ankietaService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Zamkniête extends Pytanie {

    @OneToMany(mappedBy = "pytanieZamkniete", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<WariantOdpowiedzi> wariantyOdpowiedzi;

}