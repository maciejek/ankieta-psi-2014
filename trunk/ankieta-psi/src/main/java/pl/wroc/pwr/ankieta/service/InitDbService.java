package pl.wroc.pwr.ankieta.service;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.User;
import pl.wroc.pwr.ankieta.repository.UserRepository;

@Service
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public class InitDbService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setEmail("bugi@pwr.edu.pl");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user1.setPassword(encoder.encode("bugi"));
        userRepository.save(user1);
    }
}
