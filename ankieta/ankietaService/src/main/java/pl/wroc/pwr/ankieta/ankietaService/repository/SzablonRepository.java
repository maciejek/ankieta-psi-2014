package pl.wroc.pwr.ankieta.ankietaService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Szablon;
@Repository
public interface SzablonRepository extends JpaRepository<Szablon, Integer> {

	public List<Szablon> findAll();

}