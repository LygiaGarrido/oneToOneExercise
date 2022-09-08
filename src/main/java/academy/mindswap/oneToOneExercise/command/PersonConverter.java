package academy.mindswap.oneToOneExercise.command;

import academy.mindswap.oneToOneExercise.model.Person;

public class PersonConverter {
    public static PersonDto convertToDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .build();
    }

    public static Person convertToEntity(PersonDto personDto){
        return Person.builder()
                .id(personDto.getId())
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .build();
    }

    public static Person convertCreatePersonDtoToEntity(CreatePersonDto createPersonDto) {
        return Person.builder()
                .firstName(createPersonDto.getFirstName())
                .lastName(createPersonDto.getLastName())
                .email(createPersonDto.getEmail())
                .address(createPersonDto.getAddress())
                .password(createPersonDto.getPassword())
                .build();
    }
}
