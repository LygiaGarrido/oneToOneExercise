package academy.mindswap.oneToOneExercise.command;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
