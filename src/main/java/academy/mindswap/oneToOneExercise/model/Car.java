package academy.mindswap.oneToOneExercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Entity
@Data
@ToString(exclude = "owner")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String brand;
    private String model;
    private String licensePlate;
    private String color;

    @OneToOne
    @JsonIgnore
    private Person owner;

    public Car() {
    }
}
