package TrackingCaloriesProject.FirstApp.module.Components;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Getter
@Component
@RequiredArgsConstructor
@Builder
@With
public class Profile {
    private String firstName;

    private String lastName;

    private Integer age;

    private Double weight;

    private Double height;

    private Character gender;

    private String activityGoal;

    private List<AddMeals> mealsTaken;

    public void addMeal(String name, Double quantity, Double caloriePer100gr, Double proteinPer100gr,
                        Double carbohydratePer100gr, Double fatsPer100gr) {
        AddMeals meal = AddMeals.builder()
                .name(name)
                .quantity(quantity)
                .caloriePer100gr(caloriePer100gr)
                .proteinPer100gr(proteinPer100gr)
                .carbohydratePer100gr(carbohydratePer100gr)
                .fatsPer100gr(fatsPer100gr)
                .build();

        mealsTaken.add(meal);
    }

}
