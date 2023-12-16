package TrackingCaloriesProject.FirstApp.Service;

import TrackingCaloriesProject.FirstApp.module.Components.AddMeals;
import TrackingCaloriesProject.FirstApp.module.Components.CalculateBMR;
import TrackingCaloriesProject.FirstApp.module.Components.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private CalculateBMR calculateBMR;

    private Profile profileUser;

    public Integer modifyBasedOnActivityGoal() {
        int result = setCalorieBase();
        switch (profileUser.getActivityGoal()) {
            case "Loose Fat" -> result -= 300;
            case "Maintenance" -> {
                return result;
            }
            case "Gain Muscle" -> result += 500;
        }
        return result;
    }

    public Integer setCalorieBase() {
         return calculateBMR.chooseExpression();
    }

    public double[] macronutrientConsumed() {
        List<AddMeals> meals = profileUser.getMealsTaken();

        double[] totalMacronutrients = new double[4];

        meals.forEach(meal -> {
            totalMacronutrients[0] += meal.calculateCaloriePerPortion();
            totalMacronutrients[1] += meal.calculateProteinPerPortion();
            totalMacronutrients[2] += meal.calculateCarbohydratePerPortion();
            totalMacronutrients[3] += meal.calculateFatsPerPortion();
        });

        System.out.println("Total calories consumed: " + totalMacronutrients[0]);
        System.out.println("Total Protein Consumed: " + totalMacronutrients[1]);
        System.out.println("Total Carbohydrates Consumed: " + totalMacronutrients[2]);
        System.out.println("Total Fats Consumed: " + totalMacronutrients[3]);

        return totalMacronutrients;
    }

//    public List<AddMeals> listAllMeals() {
//
//    }


}
