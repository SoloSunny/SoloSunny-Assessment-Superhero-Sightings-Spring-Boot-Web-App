/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.dao;

import com.sg.superherosightingsspringbootwebapp.entities.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface SightingDao {
    
 
    Sighting getSightingById(int sightingId);
    
 
    List<Sighting> getAllSightings();
    
   
    Sighting addSighting(Sighting sightng);
    
   
    void updateSighting(Sighting sighting);
    
    
    void deleteSightingById(int sightingId);
    
   
    List<Sighting> getSightingsByDate(LocalDate date);
    
}
