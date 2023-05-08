/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.service;

import com.sg.superherosightingsspringbootwebapp.entities.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface SightingService {

    //Returns a sighting associated in sightingId.
    Sighting getSightingById(int sightingId);

    
    List<Sighting> getAllSightings();

    
    Sighting addSighting(Sighting sightng);

    //Updates a sighting in the database.
    void updateSighting(Sighting sighting);

   
    void deleteSightingById(int sightingId);

   
    List<Sighting> getSightingsByDate(LocalDate date);
    
    void validateDate(LocalDate ld) throws InvalidDataException;

}
