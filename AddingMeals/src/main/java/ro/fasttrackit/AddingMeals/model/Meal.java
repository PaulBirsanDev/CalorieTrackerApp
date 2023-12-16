package ro.fasttrackit.AddingMeals.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
//@Entity
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Meal {

//    @Id
//    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;
    private Double quantity;
    private Double caloriePer100gr;
    private Double proteinPer100gr;
    private Double carbohydratePer100gr;
    private Double fatsPer100gr;

}
