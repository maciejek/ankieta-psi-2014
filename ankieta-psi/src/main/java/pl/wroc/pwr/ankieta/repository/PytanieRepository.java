package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Pytanie;

public interface PytanieRepository extends JpaRepository<Pytanie, Integer> {

	//TODO:public List<Pytanie> findAllForSzablon(Szablon szablon);

}