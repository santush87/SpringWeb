package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.domain.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, String> {

}

