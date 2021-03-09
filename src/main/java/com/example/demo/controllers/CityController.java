package com.example.demo.controllers;

import com.example.demo.entities.City;
import com.example.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> getCities(
            @RequestParam(value = "id", required = false) List<Long> idList) {
        if (idList != null && !idList.isEmpty()) {
            return cityService.getCityByManyId(idList);
        }
        else {
            return cityService.getCities();
        }
    }

    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable long id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/cities")
    public City postCity (@RequestBody City city) {
        return cityService.postCity(city);
    }

    @PutMapping("/cities/{id}")
    public City updateCity(@PathVariable long id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    @DeleteMapping("/cities/{id}")
    public String deleteCity(@PathVariable long id) {
        return cityService.deleteCity(id);
    }

}
