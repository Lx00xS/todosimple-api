package com.carlosemanuel.todosimple.repositories;

import com.carlosemanuel.todosimple.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Usando automação do spring para encontrar todas as Task de um usuário
    List<Task> findByUser_id(Long id);

    /*
    -> Usando o JPQL para encontrar todas as Tasks de um usuário

    @Query(value = "SELECT t FROM Task WHERE t.user.id = :user_id")
    List<Task> findByUserId(@Param("user_id") Long id);
    */

    /*
    -> Usando query SQL para encontrar todas as Tasks de um usuário

    @Query(value = "SELECT * FROM task t WHERE t.user_id = :user_id", nativeQuery = true)
    List<Task> findByUserId_quety(@Param("user_id") Long id);
     */
}
