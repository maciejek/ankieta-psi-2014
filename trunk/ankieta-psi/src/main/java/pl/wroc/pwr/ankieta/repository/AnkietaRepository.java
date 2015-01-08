package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Ankieta;

public interface AnkietaRepository extends JpaRepository<Ankieta, Integer> {

	//TODO:public Ankieta loadAnkieta(Integer idAnkiety);

}