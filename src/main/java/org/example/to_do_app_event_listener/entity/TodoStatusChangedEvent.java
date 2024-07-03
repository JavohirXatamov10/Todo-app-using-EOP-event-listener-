package org.example.to_do_app_event_listener.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class TodoStatusChangedEvent  extends ApplicationEvent {
    private final Todo todo;
    public TodoStatusChangedEvent(Object source, Todo todo) {
        super(source);
        this.todo = todo;}

}
