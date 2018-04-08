package pl.wspolnota.mieszkaniowa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class HousingAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adress;

    @OneToMany(mappedBy = "housingAssociation")
    private List<Apartament> apartaments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Apartament> getApartaments() {
        return apartaments;
    }

    public void setApartaments(List<Apartament> apartaments) {
        this.apartaments = apartaments;
    }
}
