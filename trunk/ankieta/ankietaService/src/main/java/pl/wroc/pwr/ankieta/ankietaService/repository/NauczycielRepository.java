package pl.wroc.pwr.ankieta.ankietaService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;
@Repository
public interface NauczycielRepository extends JpaRepository<Nauczyciel, Integer> {

    
	public List<Nauczyciel> findAll();

}