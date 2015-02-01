package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Zajecia;

public interface ZajeciaRepository extends JpaRepository<Zajecia, Integer> {

	//TODO:public List<Zajecia> findAllForNauczyciel(Nauczyciel nauczyciel);

}