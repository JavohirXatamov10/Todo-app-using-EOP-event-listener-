package org.example.to_do_app_event_listener.component;

import lombok.RequiredArgsConstructor;
import org.example.to_do_app_event_listener.entity.Todo;
import org.example.to_do_app_event_listener.repo.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runnuble implements CommandLineRunner {
    private final TodoRepository todoRepository;
    @Override
    public void run(String... args) throws Exception {
        Todo todo1 = Todo.builder().title("Dars qilish").checkbox(false).build();
        Todo todo2 = Todo.builder().title("Darsga borish").checkbox(false).build();
        Todo todo3 = Todo.builder().title("Uy ishlari").checkbox(false).build();
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
    }
}
