package ro.fasttrackit.AddingMeals.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class CalorieCounter {
    private Double totalCaloriesConsumed;
    private Double totalProteinConsumed;
    private Double totalCarbohydrateConsumed;
    private Double totalFatsConsumed;
}
