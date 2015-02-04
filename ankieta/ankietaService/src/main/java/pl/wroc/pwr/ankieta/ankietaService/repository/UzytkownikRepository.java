package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Uzytkownik;
@Repository
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {
    
    Uzytkownik findByEmail(String email);

}
