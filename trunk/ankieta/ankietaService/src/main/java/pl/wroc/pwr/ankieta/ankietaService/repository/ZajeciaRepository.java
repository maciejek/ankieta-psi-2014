package pl.wroc.pwr.ankieta.ankietaService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;

public interface ZajeciaRepository extends JpaRepository<Zajecia, Integer> {
    
	@Query("select z from Zajecia z join z.nauczyciele n where n = ?1")
	public List<Zajecia> findAllForNauczyciel(Nauczyciel nauczyciel);
	
	public Zajecia findById(Integer id);

}