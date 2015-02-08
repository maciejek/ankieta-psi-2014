package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Otwarte;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zamkniête;
@Repository
public interface OtwarteRepository extends JpaRepository<Otwarte, Integer> {

    
}