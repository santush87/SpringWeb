package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.domain.entities.UserRoleEntity;
import bg.softuni.mobilele.domain.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, String> {


    Optional<UserRoleEntity> findByRole(RoleEnum role);
}
