package pl.wroc.pwr.ankieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Nauczyciel;

public interface NauczycielRepository extends JpaRepository<Nauczyciel, Integer> {

	public List<Nauczyciel> findAll();

}