package ro.fasttrackit.AddingMeals.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.AddingMeals.model.Meal;
import ro.fasttrackit.AddingMeals.reader.MealsReader;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddMealsService {
    private final MealsReader reader;
    private final List<Meal> meals;

    @PostConstruct
    void init() {
        meals.addAll(reader.readMeals());
    }

    public List<Meal> listALlMeals() {
        return meals;
    }




}
