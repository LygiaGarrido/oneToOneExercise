package academy.mindswap.oneToOneExercise.command;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatePersonDto {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;
}
