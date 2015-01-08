package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Nauczyciel;

public interface ZajeciaRepository extends JpaRepository<Nauczyciel, Integer> {

	//TODO:public List<Zajecia> findAllForNauczyciel(Nauczyciel nauczyciel);

}