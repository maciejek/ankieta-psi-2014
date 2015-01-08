package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Ankietowany;

public interface AnkietowanyRepository extends JpaRepository<Ankietowany, Integer> {

	//TODO:public List<Ankietowany> findAllForZajecia(Zajecia zajecia);

}