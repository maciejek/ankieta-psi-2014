package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Uzytkownik;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {
    
    Uzytkownik findByEmail(String email);

}
