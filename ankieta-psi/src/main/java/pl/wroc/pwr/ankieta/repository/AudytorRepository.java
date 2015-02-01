package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Audytor;

public interface AudytorRepository extends JpaRepository<Audytor, Integer> {

}
