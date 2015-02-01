package pl.wroc.pwr.ankieta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import pl.wroc.pwr.ankieta.annotation.UniqueEmail;

@Entity
@Table(name="Uzytkownik")
public abstract class Uzytkownik {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Email(message = "Nieprawid³owy adres e-amail.")
    @Size(min = 1, message = "Adres e-mail jest wymagany.")
    @Column(unique = true)
    @UniqueEmail(message = "Podany e-mail ju¿ istnieje.")
	private String email;

    @Size(min = 4, message = "Has³o musi mieæ przynajmniej 4 znaki.")
	private String haslo;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

}