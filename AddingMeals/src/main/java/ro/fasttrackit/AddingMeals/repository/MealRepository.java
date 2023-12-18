package ro.fasttrackit.AddingMeals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.AddingMeals.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
}
