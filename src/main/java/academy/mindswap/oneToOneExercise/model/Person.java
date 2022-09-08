package academy.mindswap.oneToOneExercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Entity
@Data

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;

    @OneToOne (mappedBy = "owner")
    private Car car;

    public Person() {
    }
}
