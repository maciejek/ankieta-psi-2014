package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Audytor;
import pl.wroc.pwr.ankieta.ankietaService.entity.Nauczyciel;

@Repository
public interface AudytorRepository extends JpaRepository<Audytor, Integer> {

    public Audytor findByEmail(String email);
}
