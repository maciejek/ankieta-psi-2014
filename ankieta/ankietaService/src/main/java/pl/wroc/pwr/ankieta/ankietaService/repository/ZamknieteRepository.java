package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Zamkniete;
@Repository
public interface ZamknieteRepository extends JpaRepository<Zamkniete, Integer> {

}