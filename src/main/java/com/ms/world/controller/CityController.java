/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.world.controller;

import com.ms.world.model.City;
import com.ms.world.repo.CityRepo;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a1024408
 */
@RestController
@RequestMapping("/city-api")
public class CityController {
    
    private static Logger log = LoggerFactory.getLogger(CityController.class);
    
    @Autowired
    CityRepo cityRepo;
    
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getAllCountries(){
        return cityRepo.findAll();
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public City postCity(City city) {
        log.debug(city.toString());
        return cityRepo.save(city);
    }
}
