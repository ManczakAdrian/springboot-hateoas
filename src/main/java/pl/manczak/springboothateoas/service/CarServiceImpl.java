package pl.manczak.springboothateoas.service;

import org.springframework.stereotype.Service;
import pl.manczak.springboothateoas.model.Car;
import pl.manczak.springboothateoas.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    public List<Car> getAllCars(){
        return createListOfCars();

    }

    @Override
    public Optional<Car> getCarById(long id){
        return createListOfCars()
                .stream()
                .filter(car -> car.getCarId() == id)
                .findFirst();

    }
    @Override
    public List<Car> getCarsByColor(String color){
        return createListOfCars()
                .stream()
                .filter(car->color.equalsIgnoreCase(car.getColor().name()))
                .collect(Collectors.toList());



    }
    private List<Car>createListOfCars(){
        List<Car> carList=new ArrayList<>();
        carList.add(new Car(1L,"Mercedes","GLC300", Color.NAVY_BLUE));
        carList.add(new Car(2L,"Maserati","Quatroporte", Color.MARINE));
        carList.add(new Car(3L,"Alfa Romeo","Guilia", Color.RED));
        carList.add(new Car(4L,"Mercedes","EQC", Color.BLUE));
        carList.add(new Car(5L,"Ferrari","CAlifornia", Color.BLACK));
        carList.add(new Car(6L,"Bugatti","La Voiture Noire", Color.WHITE));
        return carList;

    }

}
