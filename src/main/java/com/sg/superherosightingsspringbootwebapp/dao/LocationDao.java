/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.dao;

import com.sg.superherosightingsspringbootwebapp.entities.Hero;
import com.sg.superherosightingsspringbootwebapp.entities.Location;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface LocationDao {
    
     
    Location getLocationById(int locationId);

 
    List<Location> getAllLocations();
    
 
    Location addLocation(Location location);


    void updateLocation(Location location);

    void deleteLocationById(int locationId);

  
    List<Location> getLocationsForHero(Hero hero);
    
}
