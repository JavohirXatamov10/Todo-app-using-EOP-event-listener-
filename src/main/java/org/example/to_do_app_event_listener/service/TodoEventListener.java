package org.example.to_do_app_event_listener.service;

import lombok.RequiredArgsConstructor;
import org.example.to_do_app_event_listener.entity.Todo;
import org.example.to_do_app_event_listener.entity.TodoLog;
import org.example.to_do_app_event_listener.entity.TodoStatusChangedEvent;
import org.example.to_do_app_event_listener.repo.TodoLogRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoEventListener {
    private final TodoLogRepository todoLogRepository;
    @EventListener
    public void handleTodoStatusChangedEvent(TodoStatusChangedEvent event) {
        Todo todo = event.getTodo();
        TodoLog log = TodoLog.builder()
                .todoId(todo.getId())
                .title(todo.getTitle())
                .description("Status changed to " + (todo.getCheckbox() ? "completed" : "incomplete"))
                .build();
        todoLogRepository.save(log);
    }
}
