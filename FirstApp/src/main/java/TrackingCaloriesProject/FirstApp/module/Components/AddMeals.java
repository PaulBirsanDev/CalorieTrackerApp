package TrackingCaloriesProject.FirstApp.module.Components;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Builder
@With
@Getter
public class AddMeals {
    private String name;
    private Double quantity;
    private Double caloriePer100gr;
    private Double proteinPer100gr;
    private Double carbohydratePer100gr;
    private Double fatsPer100gr;

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
