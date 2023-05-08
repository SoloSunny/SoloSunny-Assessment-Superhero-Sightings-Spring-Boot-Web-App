/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.service;

import com.sg.superherosightingsspringbootwebapp.entities.Hero;
import com.sg.superherosightingsspringbootwebapp.entities.Location;
import com.sg.superherosightingsspringbootwebapp.entities.Organization;
import com.sg.superherosightingsspringbootwebapp.entities.Superpower;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface HeroService {

    
    Hero getHeroById(int heroId);

  
    List<Hero> getAllHeroes();

    
    Hero addHero(Hero hero);

    
    void updateHero(Hero hero);

     
    void deleteHeroById(int heroId);

     
    List<Hero> getHeroesatLocation(Location location);

   
    List<Hero> getMembersOfOrganization(Organization organization);

   
    List<Hero> getHeroesForSuperpower(Superpower superpower);
    
    void validateHero(Hero hero) throws DuplicateNameException;

}
