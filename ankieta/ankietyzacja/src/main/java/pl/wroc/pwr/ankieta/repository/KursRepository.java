package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Kurs;

public interface KursRepository extends JpaRepository<Kurs, Integer> {
    
}
