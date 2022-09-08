package academy.mindswap.oneToOneExercise.service;


import academy.mindswap.oneToOneExercise.command.CreatePersonDto;
import academy.mindswap.oneToOneExercise.command.PersonConverter;
import academy.mindswap.oneToOneExercise.command.PersonDto;
import academy.mindswap.oneToOneExercise.model.Car;
import academy.mindswap.oneToOneExercise.model.Person;
import academy.mindswap.oneToOneExercise.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final CarService carService;

    public PersonService(PersonRepository personRepository, CarService carService) {
        this.personRepository = personRepository;
        this.carService = carService;
    }

    public PersonDto createPerson(CreatePersonDto person){

        Person personEntity = PersonConverter.convertCreatePersonDtoToEntity(person);


        personEntity = personRepository.save(personEntity);
       // car.setOwner(person);
        //carService.saveCar(car);

        return PersonConverter.convertToDto(personEntity);
    }


    public Car relateCarToPerson( Integer idPerson, Car car){
        Person person = personRepository.findById(idPerson).orElseThrow();
        car.setOwner(person);
        car = carService.saveCar(car);
        return car;
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Person findById (Integer id){
        return personRepository.findById(id).orElseThrow();
    }

}
