package pl.wspolnota.mieszkaniowa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wspolnota.mieszkaniowa.model.Inhabitant;
@Repository
public interface InhabitantRepository extends JpaRepository<Inhabitant,Long> {
}
