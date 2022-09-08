package academy.mindswap.oneToOneExercise.controller;

import academy.mindswap.oneToOneExercise.model.Car;
import academy.mindswap.oneToOneExercise.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCar(){
        return carService.getCarList();
    }

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Integer id){
        return carService.findById(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carService.saveCar(car);
    }
}
