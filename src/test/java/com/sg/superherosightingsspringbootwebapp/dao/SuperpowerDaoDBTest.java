/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.dao;

import com.sg.superherosightingsspringbootwebapp.entities.Hero;
import com.sg.superherosightingsspringbootwebapp.entities.Location;
import com.sg.superherosightingsspringbootwebapp.entities.Organization;
import com.sg.superherosightingsspringbootwebapp.entities.Sighting;
import com.sg.superherosightingsspringbootwebapp.entities.Superpower;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author solomon
 */
@SpringBootTest
public class SuperpowerDaoDBTest {
    
    @Autowired
    HeroDao heroDao;
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperpowerDao superpowerDao;
    
    public SuperpowerDaoDBTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        List<Hero> heroes = heroDao.getAllHeroes();
        for (Hero hero : heroes) {
            heroDao.deleteHeroById(hero.getHeroId());
        }
        
        List<Location> locations = locationDao.getAllLocations();
        for (Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());
        }
        
        List<Organization> organizations = organizationDao.getAllOrganizations();
        for ( Organization organization : organizations) {
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }
        
        List<Sighting> sightings = sightingDao.getAllSightings();
        for (Sighting sighting : sightings) {
            sightingDao.deleteSightingById(sighting.getSightingId());
        }
        
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        for (Superpower superpower : superpowers) {
            superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getSuperpowerById method, of class SuperpowerDaoDB.
     */
    @Test
    public void testAddGetSuperpowerById() {
         
        Superpower superpower = new Superpower();
        superpower.setName("batman");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);
        
        //Return dao
        Superpower fromDao =  superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        
   
        assertEquals(superpower, fromDao);
        
        
    }

    /**
     * Test of getAllSuperpowers method, of class SuperpowerDaoDB.
     */
    @Test
    public void testGetAllSuperpowers() {
   
         
 
        Superpower superpower1 = new Superpower();
        superpower1.setName("Batman");
        superpower1.setDescription("Weird magic");
        superpower1 = superpowerDao.addSuperpower(superpower1);
        
  
        Superpower superpower2 = new Superpower();
        superpower2.setName("Strong");
        superpower2.setDescription("High speed");
        superpower2 = superpowerDao.addSuperpower(superpower2);
         
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        
     
        assertEquals(2, superpowers.size());
        assertTrue(superpowers.contains(superpower1));
        assertTrue(superpowers.contains(superpower2));
    }

    
    /**
     * Test of updateSuperpower method, of class SuperpowerDaoDB.
     */
    @Test
    public void testUpdateSuperpower() {
   
        Superpower superpower = new Superpower();
        superpower.setName("Batman");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);
        
    
        Superpower fromDao =  superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        
    
        assertEquals(superpower, fromDao);
        
   
        superpower.setName("Fly");
        superpower.setDescription("high");
 
        superpowerDao.updateSuperpower(superpower);
        
  
        assertNotEquals(superpower, fromDao);
        
 
        fromDao =  superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        
 
        assertEquals(superpower, fromDao);
    }

    /**
     * Test of deleteSuperpowerById method, of class SuperpowerDaoDB.
     */
    @Test
    public void testDeleteSuperpowerById() {
   
        Superpower superpower = new Superpower();
        superpower.setName("Batman");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower fromDao =  superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        
        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Big");
        organization.setAddress("420 Sage Bluff, Calgary");
        organization.setContact("4034674567");
        organization = organizationDao.addOrganization(organization);
        
        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);
        
        Hero hero = new Hero();
        hero.setIsHero(true);
        hero.setName("Spiderman");
        hero.setDescription("Tall");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizationList);
        hero = heroDao.addHero(hero);
        
       
        
        Location location= new Location();
        location.setName("Calgary");
        location.setDescription("Mountains");
        location.setAddress("Canada");
        location.setLatitude("51.049999");
        location.setLongitude("-114.066666");
        location= locationDao.addLocation(location);
        
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        LocalDate date = LocalDate.of(2023,5,5);
        sighting.setDate(date);
        sighting= sightingDao.addSighting(sighting);
        
 
        assertEquals(superpower, fromDao);
        
     
        superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        
        //Retrun again
        fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        
        
        assertNull(fromDao);
        
    }
    
    @Test
    public void testGetSuperpowerForHero() {

   
        Superpower superpower = new Superpower();
        superpower.setName("Magic");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);

        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());

        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Big");
        organization.setAddress("420 Sage Bluff, Calgary");
        organization.setContact("4034674567");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);

        Hero hero = new Hero();
        hero.setIsHero(true);
        hero.setName("Spiderman");
        hero.setDescription("Tall");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizationList);
        hero = heroDao.addHero(hero);

        Superpower forHero = superpowerDao.getSuperpowerForHero(hero);

     
        assertEquals(forHero, superpower);
    }
}
