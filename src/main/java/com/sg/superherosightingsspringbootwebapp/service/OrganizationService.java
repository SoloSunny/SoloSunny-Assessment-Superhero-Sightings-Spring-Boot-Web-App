/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.service;

import com.sg.superherosightingsspringbootwebapp.entities.Hero;
import com.sg.superherosightingsspringbootwebapp.entities.Organization;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface OrganizationService {
    
     //Returns an organizationId.
    Organization getOrganizationById(int organizationId);

   
    List<Organization> getAllOrganizations();

    
    Organization addOrganization(Organization Organization);

    //Updates an organization in the database.
    void updateOrganization(Organization organization);

    
    void deleteOrganizationById(int organizationId);

   
    List<Organization> getOrganizationsForHero(Hero hero);

    void validateContact(String contact) throws InvalidDataException;

    void validateOrganization(Organization organization) throws DuplicateNameException;

}
