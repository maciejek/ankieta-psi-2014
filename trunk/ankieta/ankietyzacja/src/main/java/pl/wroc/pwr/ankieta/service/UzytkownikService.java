package pl.wroc.pwr.ankieta.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Uzytkownik;
import pl.wroc.pwr.ankieta.repository.UzytkownikRepository;

@Service
@Transactional
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public class UzytkownikService {
    
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    
    private BCryptPasswordEncoder encoder;
    
    public BCryptPasswordEncoder getEncoder() {
        if (encoder == null) {
            encoder = new BCryptPasswordEncoder();
        }
        return encoder;
    }

    public List<Uzytkownik> findAll() {
        return uzytkownikRepository.findAll();
    }

    public Uzytkownik findOne(String email) {
        return uzytkownikRepository.findByEmail(email);
    }
    
    public Uzytkownik getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return findOne(authentication.getName());
    }

    public Uzytkownik registerUser(Uzytkownik user) {
        user.setHaslo(encryptPassword(user.getHaslo()));
        return uzytkownikRepository.save(user);
    }
    
    public Uzytkownik updatePassword(String name, String password) {
        Uzytkownik user = findOne(name);
        user.setHaslo(encryptPassword(password));
        return uzytkownikRepository.save(user);
    }
    
    public String encryptPassword(String plainPassword) {
        return getEncoder().encode(plainPassword);
    }
    
    public Boolean isLoggedUserPasswordCorrect(String password) {
        Uzytkownik loggedUser = getLoggedUser();
        return getEncoder().matches(password, loggedUser.getHaslo());
    }
    
    public Boolean canChangePassword(String oldPassword, String newPassword, String confirmPassword) {
        return isLoggedUserPasswordCorrect(oldPassword) && newPassword.equals(confirmPassword);
    }
}
