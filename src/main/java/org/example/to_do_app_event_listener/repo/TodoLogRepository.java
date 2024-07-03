package org.example.to_do_app_event_listener.repo;

import org.example.to_do_app_event_listener.entity.TodoLog;
import org.example.to_do_app_event_listener.entity.TodoStatusChangedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoLogRepository extends JpaRepository<TodoLog, Integer> {
}