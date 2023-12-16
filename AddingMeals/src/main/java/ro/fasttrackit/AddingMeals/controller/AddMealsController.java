package ro.fasttrackit.AddingMeals.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.AddingMeals.model.Meal;
import ro.fasttrackit.AddingMeals.service.AddMealsService;

import java.util.List;

@RestController
@RequestMapping("meals")
@RequiredArgsConstructor
public class AddMealsController {
    private final AddMealsService service;

    @GetMapping
    List<Meal> getAll() {
        return service.listALlMeals();
    }
}
