package pl.wroc.pwr.ankieta.ankietaService.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import pl.wroc.pwr.ankieta.ankietaService.repository.UzytkownikRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

    @Autowired
    private UzytkownikRepository userRepository;
    
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (userRepository == null) {
            return true;
        }
        return userRepository.findByEmail(email) == null;
    }
}
