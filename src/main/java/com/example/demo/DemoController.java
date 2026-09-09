package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/")
    public Map<String, String> welcome() {
        return Map.of(
                "message", "Welcome! This is a Java + Gradle (Spring Boot) practice app.",
                "stack", "Java 17 / Spring Boot / Gradle"
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }

    @GetMapping("/api/items")
    public List<Map<String, Object>> items() {
        return List.of(
                Map.of("id", 1, "name", "Notebook"),
                Map.of("id", 2, "name", "Pen"),
                Map.of("id", 3, "name", "Backpack"),
                Map.of("id", 4, "name", "Water Bottle")
        );
    }
}
