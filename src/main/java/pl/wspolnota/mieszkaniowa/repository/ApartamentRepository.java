package pl.wspolnota.mieszkaniowa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.wspolnota.mieszkaniowa.model.Apartament;
@Repository
public interface ApartamentRepository extends JpaRepository<Apartament,Long> {

}
