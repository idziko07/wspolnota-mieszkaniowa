package pl.wspolnota.mieszkaniowa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Apartament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int area;

    @ManyToOne
    private HousingAssociation housingAssociation;

    @OneToMany(mappedBy = "apartament")
    private List<Inhabitant> inhabitantList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public HousingAssociation getHousingAssociation() {
        return housingAssociation;
    }

    public void setHousingAssociation(HousingAssociation housingAssociation) {
        this.housingAssociation = housingAssociation;
    }

    public List<Inhabitant> getInhabitantList() {
        return inhabitantList;
    }

    public void setInhabitantList(List<Inhabitant> inhabitantList) {
        this.inhabitantList = inhabitantList;
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "id=" + id +
                ", number=" + number +
                ", area=" + area +
                '}';
    }
}

