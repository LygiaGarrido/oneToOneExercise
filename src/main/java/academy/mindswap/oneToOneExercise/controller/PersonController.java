package academy.mindswap.oneToOneExercise.controller;

import academy.mindswap.oneToOneExercise.command.CreatePersonDto;
import academy.mindswap.oneToOneExercise.command.PersonDto;
import academy.mindswap.oneToOneExercise.model.Car;
import academy.mindswap.oneToOneExercise.model.Person;
import academy.mindswap.oneToOneExercise.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> personList = personService.getAllPerson();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) {
        if(id==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personService.findById(id);
        if(person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody CreatePersonDto person){
        if(person == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/car")
    public ResponseEntity<Car> addCarToPerson(@PathVariable Integer id, @RequestBody Car car){
        if(car == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(personService.relateCarToPerson(id, car), HttpStatus.OK);

    }


}
