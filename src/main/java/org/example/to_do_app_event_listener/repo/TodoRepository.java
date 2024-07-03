package org.example.to_do_app_event_listener.repo;

import org.example.to_do_app_event_listener.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}