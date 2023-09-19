package com.aleksandrov.battleShips.repositories;

import com.aleksandrov.battleShips.enums.ShipType;
import com.aleksandrov.battleShips.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(ShipType name);
}
