package ro.fasttrackit.AddingMeals;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ro.fasttrackit.AddingMeals.service.AddMealsService;

@SpringBootApplication
@EnableConfigurationProperties
public class AddingMealsApplication{

	public static void main(String[] args) {
		SpringApplication.run(AddingMealsApplication.class, args);
	}
}
