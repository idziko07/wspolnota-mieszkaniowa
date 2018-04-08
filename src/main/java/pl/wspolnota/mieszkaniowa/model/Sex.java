package pl.wspolnota.mieszkaniowa.model;

public enum Sex {
    M("mezczyzna"),
    F("kobieta");

    String nameSex;

    Sex(String nameSex) {
        this.nameSex = nameSex;
    }

    public String getNameSex(){
        return nameSex;
    }
}
