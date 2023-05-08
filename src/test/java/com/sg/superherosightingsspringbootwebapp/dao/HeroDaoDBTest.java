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
public class HeroDaoDBTest {
    
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
    
    public HeroDaoDBTest() {
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
        for (Organization organization : organizations) {
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
     * Test of getHeroById method, of class HeroDaoDB.
     */
    @Test
    public void testAddGetHeroById() {
        
        Superpower superpower = new Superpower();
        superpower.setName("Magic");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);

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
        hero.setName("Batman");
        hero.setDescription("Strong");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizationList);

       
        hero = heroDao.addHero(hero);

     
        Hero fromDao = heroDao.getHeroById(hero.getHeroId());

       
        assertEquals(hero, fromDao);
    }

    /**
     * Test of getAllHeroes method, of class HeroDaoDB.
     */
    @Test
    public void testGetAllHeroes() {
       
       
        Superpower superpower1 = new Superpower();
        superpower1.setName("Magic");
        superpower1.setDescription("Weird magic");
        superpower1 = superpowerDao.addSuperpower(superpower1);

    
        Superpower superpower2 = new Superpower();
        superpower2.setName("Strong");
        superpower2.setDescription("High speed");
        superpower2 = superpowerDao.addSuperpower(superpower2);
 
        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Big");
        organization.setAddress("420 Sage Bluff, Calgary");
        organization.setContact("4034674567");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);

      
        Hero hero1 = new Hero();
        hero1.setIsHero(true);
        hero1.setName("Superman");
        hero1.setDescription("Flyer");
        hero1.setSuperpower(superpower1);
        hero1.setOrganizations(organizationList);
        hero1 = heroDao.addHero(hero1);

  
        Hero hero2 = new Hero();
        hero2.setIsHero(true);
        hero2.setName("Spiderman");
        hero2.setDescription("Web releaser");
        hero2.setSuperpower(superpower2);
        hero2.setOrganizations(organizationList);
     
        hero2 = heroDao.addHero(hero2);

      
        List<Hero> list = heroDao.getAllHeroes();

   
        assertEquals(2, list.size());

      
        assertTrue(list.contains(hero1));
        assertTrue(list.contains(hero2));
    }

    /**
     * Test of updateHero method, of class HeroDaoDB.
     */
    @Test
    public void testUpdateHero() {
      
        Superpower superpower = new Superpower();
        superpower.setName("Batman");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);

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
        hero.setName("Widerman");
        hero.setDescription("Tall");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizationList);
   
        hero = heroDao.addHero(hero);

     
        Hero fromDao = heroDao.getHeroById(hero.getHeroId());

 
        assertEquals(hero, fromDao);
 
        hero.setName("Superman");
 
        Organization organization2 = new Organization();
        organization2.setIsHero(true);
        organization2.setName("Wonder Organization");
        organization2.setDescription("Good");
        organization2.setAddress("23 SE, Calgary");
        organization2.setContact("4034785623");
        organization2 = organizationDao.addOrganization(organization2);

        organizationList.add(organization2);
        hero.setOrganizations(organizationList);

    
        heroDao.updateHero(hero);

 
        assertNotEquals(hero, fromDao);

    
        fromDao = heroDao.getHeroById(hero.getHeroId());

   
        assertEquals(hero, fromDao);

    }

    /**
     * Test of deleteHeroById method, of class HeroDaoDB.
     */
    @Test
    public void testDeleteHeroById() {
       
        Superpower superpower = new Superpower();
        superpower.setName("Batman");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);
 
        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("High speed");
        organization.setAddress("420 Sage Bluff, Calgary");
        organization.setContact("4034674567");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);

 
        Hero hero = new Hero();
        hero.setIsHero(true);
        hero.setName("Widerman");
        hero.setDescription("Tall");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizationList);

    
        hero = heroDao.addHero(hero);

      
        Location location = new Location();
        location.setName("Calgary");
        location.setDescription("Mountains");
        location.setAddress("Canada");
        location.setLatitude("51.049999");
        location.setLongitude("114.066666");
        location = locationDao.addLocation(location);

        //sighting
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        LocalDate date = LocalDate.parse("2023-05-05");
        sighting.setDate(date);
        sighting = sightingDao.addSighting(sighting);

       
        heroDao.deleteHeroById(hero.getHeroId());

        //Returns the object 
        Hero fromDao = heroDao.getHeroById(hero.getHeroId());
        assertNull(fromDao);
    }

    /**
     * Test of getHeroesatLocation method, of class HeroDaoDB.
     */
    @Test
    public void testGetHeroesatLocation() {
         
        Superpower superpower1 = new Superpower();
        superpower1.setName("Magic");
        superpower1.setDescription("Weird magic");
        superpower1 = superpowerDao.addSuperpower(superpower1);

       
        Superpower superpower2 = new Superpower();
        superpower2.setName("Batman");
        superpower2.setDescription("High speed");
        superpower2 = superpowerDao.addSuperpower(superpower2);

        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Big");
        organization.setAddress("420 Sage Bluff, Calgary");
        organization.setContact("4034674567");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);

      
        Hero hero1 = new Hero();
        hero1.setIsHero(true);
        hero1.setName("Widerman");
        hero1.setDescription("Tall");
        hero1.setSuperpower(superpower1);
        hero1.setOrganizations(organizationList);
      
        hero1 = heroDao.addHero(hero1);

        Location location = new Location();
        location.setName("Calgary");
        location.setDescription("Mountains");
        location.setAddress("Canada");
        location.setLatitude("51.049999");
        location.setLongitude("-114.066666");
      
        location = locationDao.addLocation(location);

      
        Hero hero2 = new Hero();
        hero2.setIsHero(true);
        hero2.setName("Batman");
        hero2.setDescription("High speed");
        hero2.setSuperpower(superpower2);
        hero2.setOrganizations(organizationList);
       
        hero2 = heroDao.addHero(hero2);

     
        Sighting sighting1 = new Sighting();
        sighting1.setHero(hero1);
        sighting1.setLocation(location);
        LocalDate date = LocalDate.of(2023, 5, 5);
        sighting1.setDate(date);
      
        sighting1 = sightingDao.addSighting(sighting1);

 
        Sighting sighting2 = new Sighting();
        sighting2.setHero(hero2);
        sighting2.setLocation(location);
        LocalDate date2 = LocalDate.of(2022, 3, 9);
        sighting2.setDate(date2);
     
        sighting2 = sightingDao.addSighting(sighting2);

    
        List<Hero> heroListAtLocation = heroDao.getHeroesatLocation(location);

 
        assertEquals(2, heroListAtLocation.size());
        assertTrue(heroListAtLocation.contains(hero1));
        assertTrue(heroListAtLocation.contains(hero2));
    }

    /**
     * Test of getMembersOfOrganization method, of class HeroDaoDB.
     */
    @Test
    public void testGetMembersOfOrganization() {
     
        Superpower superpower1 = new Superpower();
        superpower1.setName("Magic");
        superpower1.setDescription("Weird magic");
     
        superpower1 = superpowerDao.addSuperpower(superpower1);

        Superpower superpower2 = new Superpower();
        superpower2.setName("Strong");
        superpower2.setDescription("High speed");
      
        superpower2 = superpowerDao.addSuperpower(superpower2);

        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Big");
        organization.setAddress("420 Sage Bluff, Calgary");
        organization.setContact("4034674567");
 
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);

    
        Hero hero1 = new Hero();
        hero1.setIsHero(true);
        hero1.setName("Spiderman");
        hero1.setDescription("Tall");
        hero1.setSuperpower(superpower1);
        hero1.setOrganizations(organizationList);
   
        hero1 = heroDao.addHero(hero1);

  
        Hero hero2 = new Hero();
        hero2.setIsHero(true);
        hero2.setName("Spiderman");
        hero2.setDescription("Tall");
        hero2.setSuperpower(superpower2);
        hero2.setOrganizations(organizationList);
  
        hero2 = heroDao.addHero(hero2);

        //Returns lists
        List<Hero> memberList = heroDao.getMembersOfOrganization(organization);
        
        assertEquals(2, memberList.size());
        assertTrue(memberList.contains(hero1));
        assertTrue(memberList.contains(hero2));

    }
    
     @Test
    public void testGetHeroesForSuperpower() {
        
    
 
        Superpower superpower = new Superpower();
        superpower.setName("Magic");
        superpower.setDescription("Weird magic");
        superpower = superpowerDao.addSuperpower(superpower);
 
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
        
     
        List<Hero> heroList= heroDao.getHeroesForSuperpower(superpower);
        
        
        assertEquals(1, heroList.size());
        assertTrue(heroList.contains(hero));
        
    }

}
