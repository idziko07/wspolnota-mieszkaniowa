package pl.wspolnota.mieszkaniowa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.wspolnota.mieszkaniowa.model.HousingAssociation;

@Repository
public interface HousingAssociationRepository extends JpaRepository<HousingAssociation,Long> {

    @Query("SELECT sum(apart.area) FROM HousingAssociation hous " +
            "JOIN hous.apartaments apart " +
            "where hous.id= :id")
    int sumArea(@Param("id") Long id);

}
