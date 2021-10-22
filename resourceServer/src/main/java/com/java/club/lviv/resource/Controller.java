package com.java.club.lviv.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/data")
    public List<String> getData() {
        return List.of("java", "club", "lviv");
    }
}
