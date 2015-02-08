package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.WariantOdpowiedzi;
@Repository
public interface WariantOdpowiedziRepository extends JpaRepository<WariantOdpowiedzi, Integer> {

}