package TrackingCaloriesProject.FirstApp.Service;

import TrackingCaloriesProject.FirstApp.module.Components.AddMeals;
import TrackingCaloriesProject.FirstApp.module.Components.CalculateBMR;
import TrackingCaloriesProject.FirstApp.module.Components.Profile;
import TrackingCaloriesProject.FirstApp.module.Enums.ActivityGoals;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private CalculateBMR calculateBMR;

    private Profile profileUser;

    private List<AddMeals> meals;

//    public List<AddMeals> mealsTaken() {
//
//    }

    public Integer modifyBasedOnActivityGoal(String activityGoal) {
        int result = setCalorieBase();
        switch (activityGoal) {
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


}
