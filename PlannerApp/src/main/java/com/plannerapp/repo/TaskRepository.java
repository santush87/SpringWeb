package com.plannerapp.repo;

import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

    @Override
    List<TaskEntity> findAll();

    List<TaskEntity> findByAssignee(UserEntity user);
    List<TaskEntity> findByAssigneeNot(UserEntity user);

    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE assignee_id IS NULL")
    List<TaskEntity> getAllAvailable();

    List<TaskEntity> findAllByAssigneeIsNull();
}
