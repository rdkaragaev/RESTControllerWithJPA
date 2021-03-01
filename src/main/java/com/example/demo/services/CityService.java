package com.example.demo.services;

import com.example.demo.entities.City;
import com.example.demo.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City postCity(City city) {
        return cityRepository.save(city);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City getCityById(long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public List<City> getCityByManyId(List<Long> idList) {
        return cityRepository.findAllById(idList);
    }

    public String deleteCity(long id) {
        cityRepository.deleteById(id);
        return "City with id = " + id + " is deleted.";
    }

    public City updateCity(long id, City city) {
        City existingCity = cityRepository.findById(id).orElse(null);

        existingCity.setName(city.getName());
        existingCity.setCondition(city.getCondition());
        existingCity.setWindVelocity(city.getWindVelocity());
        existingCity.setWindDirection(city.getWindDirection());

        return cityRepository.save(existingCity);
    }
}
