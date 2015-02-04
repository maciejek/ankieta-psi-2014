package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.AnkietaAnkietowanego;

@Repository
public interface AnkietaAnkietowanegoRepository extends JpaRepository<AnkietaAnkietowanego, Integer> {

}