package pl.wroc.pwr.ankieta.ankietaService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;
import pl.wroc.pwr.ankieta.ankietaService.entity.Zajecia;

@Repository
public interface AnkietowanyRepository extends JpaRepository<Ankietowany, Integer> {

    @Query("select a from Ankietowany a join a.zajêcia z where z = ?1")
	public List<Ankietowany> findAllForZajecia(Zajecia zajecia);

}