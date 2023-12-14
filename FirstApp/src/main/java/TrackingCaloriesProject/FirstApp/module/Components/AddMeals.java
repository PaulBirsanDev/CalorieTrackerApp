package TrackingCaloriesProject.FirstApp.module.Components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddMeals {
    private Double quantity;
    private Double caloriePer100gr;
    private Integer proteinPer100gr;
    private Integer carbohydratePer100gr;
    private Integer fatsPer100gr;

//    public AddMeals(Double quantity, Double caloriePer100gr, Integer proteinPer100gr, Integer carbohydratePer100gr, Integer fatsPer100gr) {
//        this.quantity = quantity;
//        this.caloriePer100gr = caloriePer100gr;
//        this.proteinPer100gr = proteinPer100gr;
//        this.carbohydratePer100gr = carbohydratePer100gr;
//        this.fatsPer100gr = fatsPer100gr;
//    }

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
