package TrackingCaloriesProject.FirstApp.module.Components;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddMeals {
    private String name;
    private double quantity;
    private double caloriePer100gr;
    private double proteinPer100gr;
    private double carbohydratePer100gr;
    private double fatsPer100gr;

    public Double calculateCaloriePerPortion() {
        return quantity * (caloriePer100gr / 100.00);
    }
    public Double calculateProteinPerPortion() {
        return proteinPer100gr * (caloriePer100gr / 100.00);
    }
    public Double calculateCarbohydratePerPortion() {
        return carbohydratePer100gr * (caloriePer100gr / 100.00);
    }
    public Double calculateFatsPerPortion() {
        return fatsPer100gr * (caloriePer100gr / 100.00);
    }
}
