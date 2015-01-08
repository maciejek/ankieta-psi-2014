package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.AnkietaAnkietowanego;

public interface AnkietaAnkietowanegoRepository extends JpaRepository<AnkietaAnkietowanego, Integer> {

}