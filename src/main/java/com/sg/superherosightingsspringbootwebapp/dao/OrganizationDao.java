/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.dao;

import com.sg.superherosightingsspringbootwebapp.entities.Hero;
import com.sg.superherosightingsspringbootwebapp.entities.Organization;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface OrganizationDao {
    
     
    Organization getOrganizationById(int organizationId);

   
    List<Organization> getAllOrganizations();

   
    Organization addOrganization(Organization Organization);

  
    void updateOrganization(Organization organization);

    
    void deleteOrganizationById(int organizationId);


    List<Organization> getOrganizationsForHero(Hero hero);
    
}
