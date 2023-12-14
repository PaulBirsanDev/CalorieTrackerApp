package TrackingCaloriesProject.FirstApp.Components;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class Objective {
    private Integer numberOfCaloriesObjective;

    private Double proteinIntake;

    private Double carbohydratesIntake;

    private Double fatsIntake;

    private Profile profile;

//    @PostConstruct
//    void setNumberOfCaloriesObjective() {
//        this.numberOfCaloriesObjective = chooseExpression();
//    }

    public Integer chooseExpression() {
        int metabolicRate;
        if (profile.getGender().equals('M')) {
            metabolicRate = calculateBasalMetabolicRateForMales();
        } else {
            metabolicRate = calculateBasalMetabolicRateForWomen();
        }
        return metabolicRate;
    }

    public Integer calculateBasalMetabolicRateForMales() {
        return (int) (10 * profile.getWeight() + 6.25 * profile.getHeight() - 5 * profile.getAge() + 5);
    }

    public Integer calculateBasalMetabolicRateForWomen() {
        return (int) (10 * profile.getWeight() + 6.25 * profile.getHeight() - 5 * profile.getAge() - 161);
    }

}
