package org.example.to_do_app_event_listener.controller;

import lombok.RequiredArgsConstructor;
import org.example.to_do_app_event_listener.entity.Todo;
import org.example.to_do_app_event_listener.repo.TodoRepository;
import org.example.to_do_app_event_listener.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoCon{
    private final TodoRepository todoRepository;
    private final TodoService todoService;
    @PostMapping("/changeStatus/{id}")
    public String changeStatus(@PathVariable Integer id, @RequestParam(required = false) Boolean checkbox) {
        Todo changedTodo = todoRepository.findById(id).get();
        if (checkbox == null) {
            checkbox = false;
        }
        changedTodo.setCheckbox(checkbox);
        Todo save = todoRepository.save(changedTodo);
        todoService.changeStatus(save);
        return "redirect:/";
    }
    @GetMapping("add")
    public String sendAddTodoPage() {
        return "addTodoPage";
    }

    @PostMapping
    public String addTodo(String todo) {
        Todo todo1= Todo.builder().title(todo).checkbox(false).build();
        todoRepository.save(todo1);
        return "redirect:/";
    }
    @PostMapping("delete/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }
}

