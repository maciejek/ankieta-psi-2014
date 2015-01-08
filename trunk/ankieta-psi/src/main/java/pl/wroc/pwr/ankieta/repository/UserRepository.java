package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
    User findByEmail(String email);

}
