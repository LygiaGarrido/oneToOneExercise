package academy.mindswap.oneToOneExercise.repository;

import academy.mindswap.oneToOneExercise.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
