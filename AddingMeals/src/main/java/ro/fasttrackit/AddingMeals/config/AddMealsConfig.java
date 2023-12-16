package ro.fasttrackit.AddingMeals.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "meals")
public class AddMealsConfig {
    private String fileLocation;

    @PostConstruct
    void printConfig() {
        System.out.println("Meals Config = " + this);
    }
}
