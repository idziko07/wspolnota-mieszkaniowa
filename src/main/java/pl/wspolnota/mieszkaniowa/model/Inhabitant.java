package pl.wspolnota.mieszkaniowa.model;

import javax.persistence.*;
@Entity
public class Inhabitant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @ManyToOne
    private Apartament apartament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Apartament getApartament() {
        return apartament;
    }

    public void setApartament(Apartament apartament) {
        this.apartament = apartament;
    }
}
