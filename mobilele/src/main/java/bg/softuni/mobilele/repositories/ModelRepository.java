package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.domain.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

}
