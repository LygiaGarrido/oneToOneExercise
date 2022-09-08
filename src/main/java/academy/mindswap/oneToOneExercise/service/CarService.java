package academy.mindswap.oneToOneExercise.service;

import academy.mindswap.oneToOneExercise.model.Car;
import academy.mindswap.oneToOneExercise.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> getCarList(){
        return carRepository.findAll();
    }

    public Car findById(Integer id){
        return carRepository.findById(id).orElseThrow();
    }
}
