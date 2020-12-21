package web.controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarsController {

    private CarServiceImpl carService;

    @Autowired
    public void setCarServiceImpl(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(defaultValue = "5") int count, Model model) {
        List<Car> carslist = carService.getListCars(count);
        model.addAttribute("carsL", carslist);

        return "cars";
    }

}