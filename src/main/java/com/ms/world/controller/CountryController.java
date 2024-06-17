/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.world.controller;

import com.ms.world.model.Country;
import com.ms.world.repo.CountryRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a1024408
 */
@RestController
@RequestMapping("/country-api")
public class CountryController {
    
    @Autowired
    CountryRepo countryRepo;
    
    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List<Country> getAllCountries(){
        return countryRepo.findAll();
    }
    
    @RequestMapping(value = "/country/{code}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Country> getCountry( @PathVariable String code){
        Optional<Country> cres = countryRepo.findById(code);
        
        if (cres.isPresent()){
            return new ResponseEntity<Country>(cres.get(), HttpStatus.OK);            
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }        
    }
}
