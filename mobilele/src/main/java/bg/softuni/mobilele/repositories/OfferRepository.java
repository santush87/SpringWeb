package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.domain.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, String> {

}
