package ro.fasttrackit.AddingMeals.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Component
public class UpdatedMeal {

    private Integer mealID;
    private Double totalCaloriesConsumed = 0.0;
    private Double totalProteinConsumed = 0.0;
    private Double totalCarbohydrateConsumed = 0.0;
    private Double totalFatsConsumed = 0.0;
}
