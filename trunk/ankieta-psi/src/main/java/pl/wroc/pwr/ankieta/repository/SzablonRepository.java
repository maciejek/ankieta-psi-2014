package pl.wroc.pwr.ankieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Szablon;

public interface SzablonRepository extends JpaRepository<Szablon, Integer> {

	public List<Szablon> findAll();

}