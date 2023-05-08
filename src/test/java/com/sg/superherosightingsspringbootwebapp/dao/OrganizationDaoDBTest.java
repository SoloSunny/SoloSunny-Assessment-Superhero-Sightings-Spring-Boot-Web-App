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
public class OrganizationDaoDBTest {
    
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
    
    public OrganizationDaoDBTest() {
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
     * Test of getOrganizationById method, of class OrganizationDaoDB.
     */
    @Test
    public void testAddGetOrganizationById() {

    
        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Giant");
        organization.setAddress("14 Sunridge, Calgary");
        organization.setContact("578-222-3333");
        organization = organizationDao.addOrganization(organization);

      
        Organization fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());

      
        assertEquals(organization, fromDao);

    }

    /**
     * Test of getAllOrganizations method, of class OrganizationDaoDB.
     */
    @Test
    public void testGetAllOrganizations() {

  
 
        Organization organization1 = new Organization();
        organization1.setIsHero(true);
        organization1.setName("Superhero Organization");
        organization1.setDescription("Sophisticated");
        organization1.setAddress("Sunridge Mall, Calgary");
        organization1.setContact("403-111-3333");
        organization1 = organizationDao.addOrganization(organization1);

  
        Organization organization2 = new Organization();
        organization2.setIsHero(true);
        organization2.setName("Spy Organization");
        organization2.setDescription("Excellent");
        organization2.setAddress("1st 13Ave SE, Calgary");
        organization2.setContact("587-222-3333");
        organization2 = organizationDao.addOrganization(organization2);

        //Returns the list 
        List<Organization> list = organizationDao.getAllOrganizations();

  
        assertEquals(2, list.size());
        assertTrue(list.contains(organization1));
        assertTrue(list.contains(organization2));

    }

    /**
     * Test of updateOrganization method, of class OrganizationDaoDB.
     */
    @Test
    public void testUpdateOrganization() {

        
        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Very good");
        organization.setAddress("Sunridge mall, Calgary");
        organization.setContact("587-222-3333");
        organization = organizationDao.addOrganization(organization);

        //Returns dao
        Organization fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());

    
        assertEquals(organization, fromDao);

        organization.setAddress("Huge Mall");
       
        organizationDao.updateOrganization(organization);

   
        assertNotEquals(organization, fromDao);

         
        fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());

   
        assertEquals(organization, fromDao);
    }

    /**
     * Test of deleteOrganizationById method, of class OrganizationDaoDB.
     */
    @Test
    public void testDeleteOrganizationById() {
      
        Superpower superpower = new Superpower();
        superpower.setName("Superman");
        superpower.setDescription("Flyer");
        superpower = superpowerDao.addSuperpower(superpower);

     
        Organization organization = new Organization();
        organization.setIsHero(true);
        organization.setName("Superhero Organization");
        organization.setDescription("Good");
        organization.setAddress("17St 17Ave SW, Calgary");
        organization.setContact("578-555-5555");
         
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);

      
        Hero hero = new Hero();
        hero.setIsHero(true);
        hero.setName("Spiderman");
        hero.setDescription("Web releaser");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizationList);
        hero = heroDao.addHero(hero);

      
        Location location = new Location();
        location.setName("Calgary");
        location.setDescription("Downtown");
        location.setAddress("Canada");
        location.setLatitude("51.049999");
        location.setLongitude("114.066666");
        location = locationDao.addLocation(location);
        
        
 
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        LocalDate date = LocalDate.parse("2023-05-05");
        sighting.setDate(date);
        sighting = sightingDao.addSighting(sighting);

  
        organizationDao.deleteOrganizationById(organization.getOrganizationId());

   
        Organization fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());

   
        assertNull(fromDao);

    }

    /**
     * Test of getOrganizationsForHero method, of class OrganizationDaoDB.
     */
    @Test
    public void testGetOrganizationsForHero() {
       
        Superpower superpower = new Superpower();
        superpower.setName("Spiderman");
        superpower.setDescription("Stronger");
        superpower = superpowerDao.addSuperpower(superpower);

   
        Organization organization1 = new Organization();
        organization1.setIsHero(true);
        organization1.setName("Superhero Organization");
        organization1.setDescription("Big");
        organization1.setAddress("15St 15Ave NE, Calgary");
        organization1.setContact("403-444-5555");
        organization1 = organizationDao.addOrganization(organization1);

  
        Organization organization2 = new Organization();
        organization2.setIsHero(true);
        organization2.setName("Spy Organization");
        organization2.setDescription("Excellent");
        organization2.setAddress("15St 15Ave NE, Calgary");
        organization2.setContact("403-444-5555");
        organization2 = organizationDao.addOrganization(organization2);

       
        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization1);
        organizationList.add(organization2);

        
        Hero hero = new Hero();
        hero.setIsHero(true);
        hero.setName("Batman");
        hero.setDescription("Giant");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizationList);
        hero = heroDao.addHero(hero);

        
        List<Organization> listForHero = organizationDao.getOrganizationsForHero(hero);
 
        assertEquals(2, listForHero.size());
        assertTrue(listForHero.contains(organization1));
        assertTrue(listForHero.contains(organization2));

    }

}
