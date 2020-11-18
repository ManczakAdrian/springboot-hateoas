package pl.manczak.springboothateoas.controler;


import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.manczak.springboothateoas.model.Car;
import pl.manczak.springboothateoas.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cars", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CarController {
    private CarService carService;

    @Autowired
 public CarController(CarService carService){ this.carService=carService;}

 @GetMapping
    public ResponseEntity<List<Car>> getCars(){
        List<Car> allCars=carService.getAllCars();
        return new ResponseEntity<>(allCars, HttpStatus.OK);


 }
 @GetMapping("/{id}")
 public ResponseEntity<Car> getCarById(@PathVariable long id){
     Optional<Car>carById=carService.getCarById(id);
     return new ResponseEntity<>(carById.get(),HttpStatus.OK);
 }

 @GetMapping("/color/{color}")
 public ResponseEntity<List<Car>> getCarByColor(@PathVariable String color){
        List<Car>carList=carService.getCarsByColor(color);
        return new ResponseEntity<>(carList,HttpStatus.OK);

 }

}
