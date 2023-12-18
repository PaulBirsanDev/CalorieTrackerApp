package ro.fasttrackit.AddingMeals.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.AddingMeals.exception.ResourceNotFoundException;
import ro.fasttrackit.AddingMeals.model.UpdatedMeal;
import ro.fasttrackit.AddingMeals.model.Meal;
import ro.fasttrackit.AddingMeals.service.AddMealsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("meals")
@RequiredArgsConstructor
public class MealsController {
    private final AddMealsService service;

    @GetMapping
    List<Meal> getAll() {
        return service.listALlMeals();
    }

    @GetMapping("{id}")
    Meal getById(@PathVariable int id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find meal with this id %s".formatted(id)));
    }

    @GetMapping("updatedMeals")
    List<UpdatedMeal> getUpdatedMeals() {
        return service.getUpdatedMeals();
    }

    @GetMapping("total")
    UpdatedMeal getTotalsCaloriesAndMacronutrientsConsumed() {
        return service.getTotalCaloriesAndMacronutrients();
    }

    @PostMapping
    Meal addMeal(@RequestBody Meal meal) {
        return service.addMeal(meal);
    }

    @DeleteMapping({"id"})
    Meal deleteMeal(@PathVariable int id) {
        return service.deleteMeal(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find country with id %s".formatted(id), id));

    }


}
