package gr.codehub.qualityassurance.repository;

import gr.codehub.qualityassurance.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Integer> {
}
