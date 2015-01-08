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
@Table(name="app_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Email(message = "Invalid email!")
    @Size(min = 1, message = "You must provide an email address!")
    @Column(unique = true)
    @UniqueEmail(message = "Such email already exists!")
    private String email;
    
    @Size(min = 4, message = "Password must be at least 4 characters!")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return email + ", " + password;
    }
    
    
}
