package ro.fasttrackit.AddingMeals.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class UpdatedMeal {
    private Integer mealID;
    private Double totalCaloriesConsumed = 0.0;
    private Double totalProteinConsumed = 0.0;
    private Double totalCarbohydrateConsumed = 0.0;
    private Double totalFatsConsumed = 0.0;
}
