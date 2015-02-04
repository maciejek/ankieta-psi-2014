package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;
@Repository
public interface ZajeciaRepository extends JpaRepository<Zajecia, Integer> {

	//TODO:public List<Zajecia> findAllForNauczyciel(Nauczyciel nauczyciel);

}