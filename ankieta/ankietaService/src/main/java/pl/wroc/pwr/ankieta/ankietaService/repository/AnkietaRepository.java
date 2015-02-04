package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankieta;

@Repository
public interface AnkietaRepository extends JpaRepository<Ankieta, Integer> {

	//TODO:public Ankieta loadAnkieta(Integer idAnkiety);

}