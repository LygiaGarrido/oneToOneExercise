package academy.mindswap.oneToOneExercise.repository;

import academy.mindswap.oneToOneExercise.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
