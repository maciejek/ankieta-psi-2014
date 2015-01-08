package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.UserStory;

public interface UserStoryRepository extends JpaRepository<UserStory, Integer> {

	
}
