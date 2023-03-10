package pro.sky.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String firstRequest() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String secondRequest() {
        return "Имя ученика, Название проекта, Дата создания проекта, Описание проекта";
    }
}
