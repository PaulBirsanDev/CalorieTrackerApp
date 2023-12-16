package ro.fasttrackit.AddingMeals.reader;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.fasttrackit.AddingMeals.config.AddMealsConfig;
import ro.fasttrackit.AddingMeals.model.Meal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
public class MealsReader {
    public static int ID = 1;
    private final AddMealsConfig config;

    public List<Meal> readMeals() {
        try (BufferedReader reader = new BufferedReader(new FileReader(config.getFileLocation()))) {
            return reader.lines()
                    .map(this::parseMeal)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Meal parseMeal(String line) {
        String[] tokens = line.split("[|]");
        return Meal.builder()
                .id(ID ++)
                .name(tokens[0])
                .quantity(Double.valueOf(tokens[1]))
                .caloriePer100gr(Double.valueOf(tokens[2]))
                .proteinPer100gr(Double.valueOf(tokens[3]))
                .carbohydratePer100gr(Double.valueOf(tokens[4]))
                .fatsPer100gr(Double.valueOf(tokens[5]))
                .build();
    }
}
