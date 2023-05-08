/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.service;

import com.sg.superherosightingsspringbootwebapp.entities.Hero;
import com.sg.superherosightingsspringbootwebapp.entities.Location;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface LocationService {
    
    //This method returns a location associated with a locationId.
    Location getLocationById(int locationId);

    
    List<Location> getAllLocations();

   
    Location addLocation(Location location);

    //Retruns in the database.
    void updateLocation(Location location);

    //Delete locationId
    void deleteLocationById(int locationId);

   
    List<Location> getLocationsForHero(Hero hero);

    void validateLocation(Location location) throws DuplicateNameException;

    void validateLatitudeLongitude(Location location) throws InvalidDataException;

}
