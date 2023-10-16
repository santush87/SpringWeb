package com.resellerapp.repository;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.enums.ConditionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConditionRepository extends JpaRepository<ConditionEntity, UUID> {

    ConditionEntity findByName(ConditionNameEnum condition);
}

