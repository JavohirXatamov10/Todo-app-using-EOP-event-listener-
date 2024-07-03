package org.example.to_do_app_event_listener.service;

import lombok.RequiredArgsConstructor;
import org.example.to_do_app_event_listener.entity.Todo;
import org.example.to_do_app_event_listener.entity.TodoLog;
import org.example.to_do_app_event_listener.entity.TodoStatusChangedEvent;
import org.example.to_do_app_event_listener.repo.TodoLogRepository;
import org.example.to_do_app_event_listener.repo.TodoRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final TodoLogRepository todoLogRepository;
    @Transactional
    public void changeStatus(Todo todo) {
        eventPublisher.publishEvent(new TodoStatusChangedEvent(this, todo));
    }

}
