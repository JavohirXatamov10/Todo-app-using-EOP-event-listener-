package org.example.to_do_app_event_listener.controller;

import lombok.RequiredArgsConstructor;
import org.example.to_do_app_event_listener.entity.Todo;
import org.example.to_do_app_event_listener.repo.TodoLogRepository;
import org.example.to_do_app_event_listener.repo.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final TodoRepository todoRepository;
    private final TodoLogRepository todoLogRepository;
    @GetMapping
    public String getTodos(Model model) {
        List<Todo> all = todoRepository.findAll();
        all.sort(Comparator.comparing(Todo::getId));
        model.addAttribute("todos", all);
        return "index";
    }
}
