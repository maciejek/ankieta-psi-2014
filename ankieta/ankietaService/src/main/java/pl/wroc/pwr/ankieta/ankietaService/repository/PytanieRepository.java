package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Pytanie;
@Repository
public interface PytanieRepository extends JpaRepository<Pytanie, Integer> {

	//TODO:public List<Pytanie> findAllForSzablon(Szablon szablon);

}