package ro.fasttrackit.AddingMeals.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.AddingMeals.exception.ResourceNotFoundException;
import ro.fasttrackit.AddingMeals.model.UpdatedMeal;
import ro.fasttrackit.AddingMeals.model.Meal;
import ro.fasttrackit.AddingMeals.reader.MealsReader;
import ro.fasttrackit.AddingMeals.repository.MealRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddMealsService {
    private final MealsReader reader;
    private final MealRepository repository;

    @PostConstruct
    void init() {
        repository.saveAll(reader.readMeals());
    }

    public List<Meal> listALlMeals() {
        return repository.findAll();
    }

    public Meal addMeal(Meal meal) {
        return repository.save(meal);
    }

    public Meal editMeal(Meal potentialNewMeal, int id) {
        Meal meal = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find country with id %s".formatted(id), id));
        meal.setName(potentialNewMeal.getName() == null ? meal.getName() : potentialNewMeal.getName());
        meal.setCaloriePer100gr(potentialNewMeal.getCaloriePer100gr() == null ? meal.getCaloriePer100gr() : potentialNewMeal.getCaloriePer100gr());
        meal.setProteinPer100gr(potentialNewMeal.getProteinPer100gr() == null ? meal.getProteinPer100gr() : potentialNewMeal.getProteinPer100gr());
        meal.setCarbohydratePer100gr(potentialNewMeal.getCarbohydratePer100gr() == null ? meal.getCarbohydratePer100gr() : potentialNewMeal.getCarbohydratePer100gr());
        meal.setFatsPer100gr(potentialNewMeal.getFatsPer100gr() == null ? meal.getFatsPer100gr() : potentialNewMeal.getFatsPer100gr());
        
        return repository.save(meal);
    }

    public Optional<Meal> deleteMeal(int id) {
        Optional<Meal> mealOptional = findById(id);
        mealOptional.ifPresent(repository::delete);
        return mealOptional;
    }

    public UpdatedMeal getTotalCaloriesAndMacronutrients() {
        UpdatedMeal totals = new UpdatedMeal();
        List<UpdatedMeal> updatedMeals = getUpdatedMeals();

        for (UpdatedMeal meal : updatedMeals) {
            totals.setTotalCaloriesConsumed(totals.getTotalCaloriesConsumed() + meal.getTotalCaloriesConsumed());
            totals.setTotalProteinConsumed(totals.getTotalProteinConsumed() + meal.getTotalProteinConsumed());
            totals.setTotalCarbohydrateConsumed(totals.getTotalCarbohydrateConsumed() + meal.getTotalCarbohydrateConsumed());
            totals.setTotalFatsConsumed(totals.getTotalFatsConsumed() + meal.getTotalFatsConsumed());
        }

        return totals;

    }

    public List<UpdatedMeal> getUpdatedMeals() {
        List<UpdatedMeal> updatedMeal = new ArrayList<>();
        repository.findAll().stream()
                .filter(meal -> meal.getQuantity() != null)
                .forEach(meal -> {
            updatedMeal.add(caloriesPerMeal(meal));
        });

        return updatedMeal;
    }

    public Optional<Meal> findById(int id) {
        return repository.findById(id);
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
        return (meal.getQuantity() * (meal.getCaloriePer100gr() / 100.00));
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
