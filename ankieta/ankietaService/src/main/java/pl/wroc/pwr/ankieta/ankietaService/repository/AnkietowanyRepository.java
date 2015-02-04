package pl.wroc.pwr.ankieta.ankietaService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wroc.pwr.ankieta.ankietaService.entity.Ankietowany;

@Repository
public interface AnkietowanyRepository extends JpaRepository<Ankietowany, Integer> {

	//TODO:public List<Ankietowany> findAllForZajecia(Zajecia zajecia);

}