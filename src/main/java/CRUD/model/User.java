package CRUD.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;



    @Pattern(message = "Bad formed user name: ${validatedValue} \n" +
                       "Name should starts with a capital letter and not contain symbols or numbers",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2 , max = 30, message = "Name should be more than 2 and less then 30 characters")
    @Column(name = "name")
    private String name;

    @Pattern(message = "Bad formed user surname: ${validatedValue} \n" +
                       "Surname should starts with a capital letter and not contain symbols or numbers",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 40, message = "Surname should be between 2 and 40 characters")
    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name="Email")
    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;

    public User( String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(){}
}
