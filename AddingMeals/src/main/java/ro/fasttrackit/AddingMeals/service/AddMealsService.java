package ro.fasttrackit.AddingMeals.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.AddingMeals.model.UpdatedMeal;
import ro.fasttrackit.AddingMeals.model.Meal;
import ro.fasttrackit.AddingMeals.reader.MealsReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddMealsService {
    private final MealsReader reader;
    private final List<Meal> meals;

    @PostConstruct
    void init() {
        meals.clear();
        meals.addAll(reader.readMeals());
    }

    public List<Meal> listALlMeals() {
        return meals;
    }

    public List<UpdatedMeal> getUpdatedMeals() {
        List<UpdatedMeal> updatedMeal = new ArrayList<>();
        meals.forEach(meal -> {
             updatedMeal.add(caloriesPerMeal(meal));
        });

        return updatedMeal;
    }

    public Optional<Meal> findById(int id) {
        return meals.stream()
                .filter(meal -> meal.getId() == id)
                .findFirst();
    }

    private UpdatedMeal caloriesPerMeal(Meal meal) {
        UpdatedMeal updatedMeal = new UpdatedMeal();
        updatedMeal.setMealID(meal.getId());
        updatedMeal.setTotalCaloriesConsumed(calculateCaloriePerPortion(meal));
        updatedMeal.setTotalProteinConsumed(calculateProteinPerPortion(meal));
        updatedMeal.setTotalCarbohydrateConsumed(calculateCarbohydratePerPortion(meal));
        updatedMeal.setTotalFatsConsumed(calculateFatsPerPortion(meal));

        return updatedMeal;
    }

    private Double calculateCaloriePerPortion(Meal meal) {
        return meal.getQuantity() * (meal.getCaloriePer100gr() / 100.00);
    }
    private Double calculateProteinPerPortion(Meal meal) {
        return meal.getProteinPer100gr() * (meal.getQuantity() / 100.00);
    }
    private Double calculateCarbohydratePerPortion(Meal meal) {
        return meal.getCarbohydratePer100gr() * (meal.getQuantity() / 100.00);
    }
    private Double calculateFatsPerPortion(Meal meal) {
        return meal.getFatsPer100gr() * (meal.getQuantity() / 100.00);
    }





}
